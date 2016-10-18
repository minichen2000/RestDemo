#[RestDemo](https://github.com/minichen2000/RestDemo)
[RestDemo](https://github.com/minichen2000/RestDemo) demonstrates how to implement RESTful service based on [Jetty](http://www.eclipse.org/jetty/)(9.3.x), [Jersey](https://jersey.java.net/)(2.x), [Jackson](http://wiki.fasterxml.com/JacksonHome)(2.x) and  [Swagger](http://swagger.io/).

##Features
* Swagger code generating
* Embedded Jetty Server
* http/https support
* GET
* GET with path parameters
* GET with returning json data (using jackson object mapping)
* POST with parsing input json data and returning json data.
* PATCH
* DELETE
* PUT

##Run it!
[Maven](http://maven.apache.org/) is used to build and run this demo. To run server *(at default port 80)*:
```
mvn test -Prun
```


#Generate Client/Server sources separately:
```
mvn generate-sources
```
#Run:
```
mvn test -Prun
```

##Switch ResourceConfig packages
switch following packages in `ResourceConfig.packages()`: 
- `com.nokia.restful.ui_ctrl.server.api`: contents from swagger.
- `com.rest.test`: contents from pure jersey/JAX-RS.

