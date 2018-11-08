/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.UserHelper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.User;

/**
 * REST Web Service
 *
 * @author ASUS
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of service.UserResource
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }

    /**
     * PUT method for updating or creating an instance of UserResource
     *
     * @param username
     * @param password
     * @param content representation for the resource
     * @return 
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)//Consumes disini berarti memakai/menggunakan informasi yang ada di paramater nya
//    public void putJson(String content) {
//    }

    @GET
    @Path("loginUser")
    @Produces(MediaType.APPLICATION_JSON)//Produces disini berarti menghasilkan informasi yang ada di return nya
    public Response getloginUser(
            @QueryParam("username") String username,
            @QueryParam("password") String password) {
        UserHelper helper = new UserHelper();
        User user = helper.getUser(username, password);
//        boolean hasil = helper.login(username, password);
        Gson gson = new Gson();

//        return Response.status(200)
//                .entity(gson.toJson(hasil))
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Methods",
//                        "GET,POST,HEAD,OPTIONS,PUT")
//                .header("Access-Control-Allow-Headers",
//                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
//                .header("Access-Exposed-Headers",
//                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
//                .header("Access-Support-Credentials",
//                        "true")
//                .header("Access-Preflight-Maxage", "2000")
//                .build();
        return Response
                .status(200)
                .entity(gson.toJson(user))
                .build();
    }
    
    @GET
    @Path("loginAdmin")
    @Produces(MediaType.APPLICATION_JSON)//Produces disini berarti menghasilkan informasi yang ada di return nya
    public Response getloginAdmin(
            @QueryParam("username") String username,
            @QueryParam("password") String password) {
        UserHelper helper = new UserHelper();
        User user = helper.getUser(username, password);
//        boolean hasil = helper.login(username, password);
        Gson gson = new Gson();

//        return Response.status(200)
//                .entity(gson.toJson(hasil))
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Methods",
//                        "GET,POST,HEAD,OPTIONS,PUT")
//                .header("Access-Control-Allow-Headers",
//                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
//                .header("Access-Exposed-Headers",
//                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
//                .header("Access-Support-Credentials",
//                        "true")
//                .header("Access-Preflight-Maxage", "2000")
//                .build();
        return Response
                .status(200)
                .entity(gson.toJson(user))
                .build();
    }
}
