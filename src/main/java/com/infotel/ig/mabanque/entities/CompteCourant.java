package com.infotel.ig.mabanque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;

/**
 *
 * @author HP
 */
@Entity
@Data
public class CompteCourant extends Compte{
    
    
    @Column(nullable = false)
    private double frais;
    
}
