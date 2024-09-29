package org.apicode;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.Repositories.AlienRepository;
import java.util.List;

@Path("aliens")
public class AlienResource {

    private static final AlienRepository repo = new AlienRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alien> getAlien(){
        return repo.getAllAliens();
    }

    @GET
    @Path("alien/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Alien getAlienById( @PathParam("id") int id){
        return repo.getAlienById(id);
    }

    @Path("addAlien")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAlien(Alien alien){
        if (alien == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Alien data is missing or invalid")
                    .build();
        }

        try {
            repo.addNewAlien(alien);  // Assuming this adds the alien to the repository
            return Response.status(Response.Status.OK)
                    .entity("Alien added successfully")
                    .build();
        } catch (Exception e) {
            // Log the error (optional)
            System.err.println("Error adding alien: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while adding the alien")
                    .build();
        }
    }

    @Path("delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAlien(@PathParam("id") int id){
       Alien x =  repo.getAlienById(id);
        repo.deleteAlien(id);
        return Response.status(Response.Status.OK)
                .entity(x) // Return the deleted alien
                .build();
    }




}
