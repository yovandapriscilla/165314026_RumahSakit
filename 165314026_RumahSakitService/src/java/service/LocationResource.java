/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.LocationHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Location;

/**
 * REST Web Service
 *
 * @author ASUS
 */
@Path("location")
public class LocationResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LocationResource
     */
    public LocationResource() {
    }

    /**
     * Retrieves representation of an instance of service.LocationResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getLocation() {
        LocationHelper helper = new LocationHelper();
        List<Location> list = helper.getLocation();
        Gson gson = new Gson();
        return Response.status(200)
                .entity(gson.toJson(list))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Preflight-Maxage", "2000")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of LocationResource
     *
     * @param content representation for the resource
     */

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
    
    @POST
    @Path("addLocation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewLocation(String data){
        Gson gson = new Gson();
        Location location = gson.fromJson(data, Location.class);
        LocationHelper helper = new LocationHelper();
        helper.addNewLocation(location.getLat(), location.getLng(), location.getName());
        return Response
                .status(200)
                .entity(location)
                .build();
    }
}
