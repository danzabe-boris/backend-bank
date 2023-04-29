package com.infotel.ig.mabanque.dto;

import com.infotel.ig.mabanque.entities.Compte;
import com.infotel.ig.mabanque.entities.CompteCourant;
import com.infotel.ig.mabanque.entities.CompteEpargne;
import com.infotel.ig.mabanque.entities.CompteType;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class CompteDto {
    private String numero;
    private double solde;
    private Date dateCreation;
    private double frais;
    private double taux;
    private int maturite;
    private CompteType type;
    
    public static Compte valueOf(CompteDto compteDto){
        Compte c;        
        if(compteDto.type == CompteType.courant){
            c = new CompteCourant();
            ((CompteCourant)c).setFrais(compteDto.getFrais());
        }else{
            c = new CompteEpargne();
            ((CompteEpargne)c).setMaturite(compteDto.getMaturite());
            ((CompteEpargne)c).setTaux(compteDto.getTaux());
        }        
        c.setDateCreation(compteDto.getDateCreation());
        c.setNumero(compteDto.getNumero());
        c.setSolde(compteDto.getSolde());
        return c;
    }
}
