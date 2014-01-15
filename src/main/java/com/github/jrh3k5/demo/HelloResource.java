package com.github.jrh3k5.demo;

import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloResource {
    private final NameProvider nameProvider;

    @Inject
    public HelloResource(NameProvider nameProvider) {
        this.nameProvider = nameProvider;
    }

    @GET
    public Response greet(@HeaderParam("CURRENT_DATE") long currentDate) throws Exception {
        return Response.ok(String.format("Howdy, %s, on %s!", nameProvider.getName(), new Date(currentDate))).build();
    }
    
    @GET
    @Path("/{greeting}")
    public Response greet(@HeaderParam("CURRENT_DATE") long currentDate, @PathParam("greeting") String greeting) throws Exception {
        return Response.ok(String.format("%s, %s, on %s!", greeting, nameProvider.getName(), new Date(currentDate))).build();
    }
}
