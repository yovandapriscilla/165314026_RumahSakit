/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.PasienHelper;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Pasien;

/**
 * REST Web Service
 *
 * @author ASUS
 */
@Path("pasien")
public class PasienResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PasienResource
     */
    public PasienResource() {
    }

    /**
     * Retrieves representation of an instance of service.PasienResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        PasienHelper test = new PasienHelper();
        List<Pasien> list = test.getAllPasien();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of PasienResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("addPasien")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPasien(String data) {
        Gson gson = new Gson();
        Pasien pasien = gson.fromJson(data, Pasien.class);
        PasienHelper helper = new PasienHelper();
        helper.addNewPasien(pasien.getNik(), pasien.getNama(), pasien.getAlamat(), pasien.getNik(),
                pasien.getTanggalLahir(), pasien.getKelamin());
        return Response
                .status(200)
                .entity(pasien)
                .build();
    }

    @GET
    @Path("cariPasien")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam("noRm") String noRm) throws ParseException {
        PasienHelper helper = new PasienHelper();
        Pasien hasilCari = helper.cariPasien(noRm);
        Gson gson = new Gson();
//        return Response.status(200)
//                .entity(json)
//                .build();
        return Response.status(200)
                .entity(gson.toJson(hasilCari))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "2")
                .header("Access-Preflight-Maxage", "2")
                .build();
    }
}
