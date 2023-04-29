package com.infotel.ig.mabanque.services;

import com.infotel.ig.mabanque.services.impl.ClientResource;
import com.infotel.ig.mabanque.services.impl.CompteResource;
import com.infotel.ig.mabanque.services.impl.OperationResource;
import com.infotel.ig.mabanque.services.impl.UtilisateurResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author HP
 */
@Component
@ApplicationPath("/api")
public class ApplicationConfig extends ResourceConfig{
    
    public ApplicationConfig(){
        register(ClientResource.class);
        register(UtilisateurResource.class);
        register(CompteResource.class);
        register(OperationResource.class);
    }
}
