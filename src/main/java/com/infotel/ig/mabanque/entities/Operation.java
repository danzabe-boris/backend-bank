package com.infotel.ig.mabanque.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
@Entity
public class Operation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOperation;
    
    @Column(nullable = false)
    private double montant;
    
    @Column(nullable = false)
    private TypeOperation typeOperation;
    
    @ManyToOne(optional = false)
    private Compte compte;
    
    
}
