package com.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/*
 GET example to parse path parameters.
 */
@Path("evcs/type/{type}/state/{state}/cancelled/{cancelled}")
public class Resource5 {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String foo(@PathParam("type") String type, @PathParam("state") int state, @PathParam("cancelled") boolean cancelled) {
        return type+" "+state+" "+cancelled;
    }
}