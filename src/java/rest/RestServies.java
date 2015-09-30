/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import exception.quoteNotFoundException;
import facade.Facade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jeanette
 */
@Path("quote")
public class RestServies
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestServies
     */
    public RestServies()
    {
    }

    @GET
    @Path("{id}")
    @Consumes("application/json")
    public Response getQuote(@PathParam("id") int id)
    {
        return Response.status(Response.Status.NOT_FOUND).entity(Facade.getQuote(id)).build();
    }

    @GET
    @Path("random")
    @Produces("application/json")
    public String getRandomQuote()
    {
        return Facade.qetRandomQuote();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String postQuote(String quote)
    {
        return Facade.createQuote(quote);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public String putQuote(@PathParam("id") int id, String quote)
    {
        return Facade.updateQuote(id, quote);
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public String deleteQuote(@PathParam("id") int id)
    {
        return Facade.deleteQuote(id);
    }
}
