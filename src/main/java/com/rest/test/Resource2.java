package com.rest.test;

import com.rest.model.Evc;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


/*
 GET example to return json data.
 */
@Path("home2")
public class Resource2 {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evc> foo() {
        List<Evc> rlt=new ArrayList<Evc>();
        rlt.add(new Evc("aTob", "p2p", 1234, new ArrayList<String>(), new ArrayList<String>()));
        return rlt;
    }
}