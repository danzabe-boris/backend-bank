
package com.infotel.ig.mabanque.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author HP
 */
@Entity
@Data
public class Utilisateur implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String nom;
    
    @NotNull
    @Email
    private String email;
    
    @NotNull
    private String password;
    
    @NotNull
    private Role role;
}
