#[RestDemo](https://github.com/minichen2000/RestDemo)
[RestDemo](https://github.com/minichen2000/RestDemo) demonstrates how to implement RESTful service based on [Jetty](http://www.eclipse.org/jetty/)(9.3.x), [Jersey](https://jersey.java.net/)(2.x) and [Jackson](http://wiki.fasterxml.com/JacksonHome)(2.x).

##Features
* GET
* GET with path parameters
* GET with returning json data (using jackson object mapping)
* POST with parsing input json data and returning json data.

##Run it!
[Maven](http://maven.apache.org/) is used to build and run this demo. Following command to run server *(at default port 80)*:
```
mvn test -Prun
```
##Test it!
> * **Simple GET:** [http://localhost/home1](http://localhost/home1)
> * **GET returning json data:** [http://localhost/home2](http://localhost/home2)
> * **GET with parsing path parameter:** [http://localhost/evcs/type/typeA](http://localhost/evcs/type/typeA)
> * **GET with parsing varials types of path parameters:** [http://localhost/evcs/type/typeA/state/1/cancelled/false](http://localhost/evcs/type/typeA/state/1/cancelled/false)
> * **POST json data and return json data:** *(Use some HTTP client tools (e.g. browser plugin) to POST this)*:
```
URL: http://localhost/home3 
Content-Type: application/json 
Request body: 
{
  "name":"aTob", 
  "type":"p2p", 
  "id":1234, 
  "aEnds":[], 
  "zEnds":[]
}
```

