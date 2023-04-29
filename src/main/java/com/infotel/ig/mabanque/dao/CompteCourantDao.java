package com.infotel.ig.mabanque.dao;

import com.infotel.ig.mabanque.entities.CompteCourant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface CompteCourantDao extends JpaRepository<CompteCourant, Long>{
    
}
