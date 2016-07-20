package com.rest.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.model.Evc;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
 POST example to parse json data and return json data.
 */
@Path("home3")
public class Resource3 {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Evc foo(Evc evc) {
        List<String> aEnds=new ArrayList<String>();
        List<String> zEnds=new ArrayList<String>();
        aEnds.add("a1");
        aEnds.add("a2");
        zEnds.add("b1");
        zEnds.add("b2");
        evc.setaEnds(aEnds);
        evc.setzEnds(zEnds);
        return evc;
    }
}