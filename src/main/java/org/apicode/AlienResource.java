package org.apicode;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("alien")
public class AlienResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Alien getAlien(){
        System.out.println("get alien called...");
        Alien a = new Alien();
        a.setName("ayush");
        a.setPoints(100);

       return a;
    }
}
