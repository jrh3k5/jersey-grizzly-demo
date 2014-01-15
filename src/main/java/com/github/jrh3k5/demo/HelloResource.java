package com.github.jrh3k5.demo;

import javax.inject.Inject;
import javax.ws.rs.GET;
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
    public Response greet() throws Exception {
        return Response.ok(String.format("Howdy, %s!", nameProvider.getName())).build();
    }
    
    @GET
    @Path("/{greeting}")
    public Response greet(@PathParam("greeting") String greeting) throws Exception {
        return Response.ok(String.format("%s, %s!", greeting, nameProvider.getName())).build();
    }
}
