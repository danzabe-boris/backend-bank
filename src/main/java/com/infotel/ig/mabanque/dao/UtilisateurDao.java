
package com.infotel.ig.mabanque.dao;

import com.infotel.ig.mabanque.entities.Role;
import com.infotel.ig.mabanque.entities.Utilisateur;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface UtilisateurDao  extends JpaRepository<Utilisateur, Long>{
    
   public Optional<Utilisateur> findByEmail(String email);
   
   public List<Utilisateur> findByNomLike(String nom);
   
   public List<Utilisateur> findByRole(Role role);
}
