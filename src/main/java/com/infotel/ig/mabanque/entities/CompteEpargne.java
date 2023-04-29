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
public class CompteEpargne extends Compte{
    
    @Column(nullable = false)
    private double taux;
    
    @Column(nullable = false)
    private int maturite;
    
}
