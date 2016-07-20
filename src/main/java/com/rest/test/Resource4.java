package com.rest.test;

import com.rest.model.Evc;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


/*
 GET example to parse path parameters.
 */
@Path("evcs/type/{type}")
public class Resource4 {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String foo(@PathParam("type") String type) {
        return type;
    }
}