package com.infotel.ig.mabanque.dao;

import com.infotel.ig.mabanque.entities.Client;
import com.infotel.ig.mabanque.entities.Compte;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface CompteDao  extends JpaRepository<Compte, Long>{
    
    public Optional<Compte> findByNumero(String numero);
    public List<Compte> findBySoldeLessThanEqual(double solde);
    public List<Compte> findBySoldeGreaterThanEqual(double solde);
    public List<Compte> findByClient(Client c);
    public List<Compte> findByClientNom(String nom);
    public Optional<Compte> findByIdAndClientId(long idCompte, long idClient);
}
