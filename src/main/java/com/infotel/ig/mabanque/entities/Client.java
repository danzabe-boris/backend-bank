package com.infotel.ig.mabanque.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author HP
 */
@Entity
@Data
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nom;
    
     @Column(nullable = false)
    private String prenom;
     
      @Column(nullable = false)
      private String profession;
     
      @Column(nullable = false)
    private Date datenais;
      
       @Column(nullable = false)
       private Boolean genre;
       
        @Column(nullable = false)
        private String mail;
        
         @Column(nullable = false)
        private String nationalité;
         
         @Column(nullable = false)
        private String villeresidence;
    
      @Column(nullable = false)
      private String adresse;
      
       @Column(nullable = false)
      private Long salaire;
    
      @Column(nullable = false)
      private String identité;
     
      @Column(nullable = false)
      private String domiciliation;
    
     @Column(nullable = false)
      private String telephone;
    
    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy = "client")
    private List<Compte> comptes;
}
