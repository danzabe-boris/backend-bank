package com.infotel.ig.mabanque.services;

import com.infotel.ig.mabanque.entities.Compte;
import com.infotel.ig.mabanque.entities.Operation;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author HP
 */
@Path("/comptes")
public interface ICompteResource {
    
    
    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Page<Compte>> getAllComptes(@QueryParam("page") @DefaultValue("0")int page, @QueryParam("size") @DefaultValue("20")int pagesize);
    
    @GET
    @Path("{id : \\d+}")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Compte> findCompte(@PathParam("id")long id);
    
    @GET
    @Path("/search")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Compte> searchCompte(@QueryParam("numero")String numero);
    
    @GET
    @Path("{id : \\d+}/operations")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public ResponseEntity<List<Operation>> getAllOperationsCompte(@PathParam("id") long id);
    
}
