package com.rest.test;

import com.rest.service.RestPtnOperationServiceFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 The simplest GET example.
 */
@Path("home1")
public class Resource1 {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String foo() {
        RestPtnOperationServiceFactory.getService().getAllNes();
        return "Hello, world!";
    }
}