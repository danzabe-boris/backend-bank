
package com.infotel.ig.mabanque.services;

import com.infotel.ig.mabanque.entities.Operation;
import com.infotel.ig.mabanque.entities.TypeOperation;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author HP
 */
@Path("/operations")
public interface IOperationResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Page<Operation>> getAllOperation(@QueryParam("type")TypeOperation type, @DefaultValue("0") @QueryParam("page")int page, @DefaultValue("20") @QueryParam("size")int size);
}
