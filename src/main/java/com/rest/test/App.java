package com.rest.test;

import com.rest.service.RestPtnOperationServiceFactory;
import com.rest.service.impl.RestPtnOperationServiceImpl;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.activation.MimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                Server docServer = new Server(8080);


                ResourceHandler files = new ResourceHandler();
                files.setServer(docServer);
                files.setResourceBase(".");
                files.setDirectoriesListed(true);

                HandlerList handlers = new HandlerList();
                handlers.setHandlers(new Handler[] {files});

                docServer.setHandler(handlers);
                try {
                    docServer.start();
                    docServer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    docServer.destroy();
                }
            }
        }).start();*/





        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(80);
        server.setConnectors(new Connector[] { connector });

        /*Enable https (Comment this block in case you don't need https)*/
        final String KEY_STORE_PATH="d:/keystore.jks";
        HttpConfiguration https = new HttpConfiguration();
        https.addCustomizer(new SecureRequestCustomizer());
        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setKeyStorePath(KEY_STORE_PATH);
        sslContextFactory.setKeyStorePassword("123456");
        sslContextFactory.setKeyManagerPassword("123456");
        ServerConnector sslConnector = new ServerConnector(server,
                new SslConnectionFactory(sslContextFactory, "http/1.1"),
                new HttpConnectionFactory(https));
        sslConnector.setPort(443);
        server.setConnectors(new Connector[] { connector, sslConnector });
        /*Enable end*/

        ResourceConfig config = new ResourceConfig()
                .packages("com.rest.test")
                //.packages("com.nokia.restful.ui_ctrl.server.api")
                //.register(MyObjectMapperProvider.class)  // No need to register this provider if no special configuration is required.
                .register(JacksonFeature.class)
                .register(CORSResponseFilter.class);
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");

        /* Add servlet for making jnlp file*/
        MimeTypes mt=new MimeTypes();
        mt.addMimeMapping("jnlp", "application/x-java-jnlp-file");
        context.setMimeTypes(mt);
        context.addServlet(MakeJnlp.class, "/startusm");
        /* End of jnlp*/


        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }


    static private  class CORSResponseFilter
            implements ContainerResponseFilter {

        public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
                throws IOException {

            MultivaluedMap<String, Object> headers = responseContext.getHeaders();

            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PATCH, PUT");
            headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Accept, Origin, access-control-allow-origin");
        }

    }
}