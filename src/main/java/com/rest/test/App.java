package com.rest.test;

import com.rest.service.RestPtnOperationServiceFactory;
import com.rest.service.impl.RestPtnOperationServiceImpl;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

        new Thread(new Runnable() {
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
        }).start();

        RestPtnOperationServiceFactory.setService(new RestPtnOperationServiceImpl());

        ResourceConfig config = new ResourceConfig()
                .packages("com.rest.test")
                //.packages("com.nokia.restful.ui_ctrl.server.api")
                //.register(MyObjectMapperProvider.class)  // No need to register this provider if no special configuration is required.
                .register(JacksonFeature.class)
                .register(CORSResponseFilter.class);
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));


        Server server = new Server(9090);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");


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
            headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
            headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Accept, Origin, access-control-allow-origin");
        }

    }
}