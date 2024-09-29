package org.apicode;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.Repositories.AlienRepository;
import java.util.List;

@Path("alien")
public class AlienResource {

    AlienRepository repo = new AlienRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alien> getAlien(){
        return repo.getAllAliens();
    }
}
