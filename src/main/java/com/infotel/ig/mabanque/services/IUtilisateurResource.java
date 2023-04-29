package com.infotel.ig.mabanque.services;

import com.infotel.ig.mabanque.entities.Utilisateur;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author HP
 */
@Path("/utilisateurs")
public interface IUtilisateurResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Page<Utilisateur>> findAllUtilisateurs(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("size") @DefaultValue("20")int size);
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Utilisateur> addUtilisateur(Utilisateur user);
    
    @GET
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Utilisateur> findUtilisateur(@PathParam("id") long id);
    
    @PUT
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathParam("id") long id, Utilisateur user);
    
    @DELETE
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUtilisateur(@PathParam("id") long id);
}
