package com.guedelho.controllers;

import com.guedelho.models.User;
import com.guedelho.services.UserService;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    UserService userService;

    @GET
    public Response listAll() {
        List<User> users = userService.list();
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@RestPath Long id) {
        return Response.ok(userService.listById(id)).build();
    }

    @POST
    public Response save(User user) {
        return Response.ok(userService.save(user)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@RestPath Long id, User user) {
        return Response.ok(userService.update(id, user)).build();
    }
}
