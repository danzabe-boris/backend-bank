package com.infotel.ig.mabanque.services.impl;

import com.infotel.ig.mabanque.dao.ClientDao;
import com.infotel.ig.mabanque.dao.CompteDao;
import com.infotel.ig.mabanque.dto.CompteDto;
import com.infotel.ig.mabanque.entities.Client;
import com.infotel.ig.mabanque.entities.Compte;
import com.infotel.ig.mabanque.entities.CompteCourant;
import com.infotel.ig.mabanque.entities.CompteEpargne;
import com.infotel.ig.mabanque.services.IClientResource;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author HP
 */
public class ClientResource implements IClientResource {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private CompteDao compteDao;

    @Override
    public Page<Client> getAllClients(int page, int pagesize) {
        return clientDao.findAll(PageRequest.of(page, pagesize));
    }

    @Override
    public Page<Client> searchClients(String nom, int page, int pagesize) {
        return clientDao.findByNomLikeIgnoreCase("%" + nom + "%", PageRequest.of(page, pagesize));
    }

    @Override
    public ResponseEntity<Client> findClient(long id) {
        Optional<Client> client = clientDao.findById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Client> updateClient(long id, Client client) {
        /*Optional<Client> oc = clientDao.findById(id);
        if (!oc.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Client c = oc.get();
        c.setAdresse(client.getAdresse());
        c.setNom(client.getNom());
        c.setTelephone(client.getTelephone());
        clientDao.save(c);
        return ResponseEntity.ok(c);*/
        return clientDao.findById(id).map(
                c -> {
                    c.setAdresse(client.getAdresse());
                    c.setNom(client.getNom());
                    c.setTelephone(client.getTelephone());
                    return ResponseEntity.ok(clientDao.save(c));
                }
        ).orElse(
                ResponseEntity.notFound().build()
        );
    }

    @Override
    public ResponseEntity<Client> addClient(Client client) {
        Client c = clientDao.save(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(location).body(c);
    }

    @Override
    public void deleteClient(long id) {
        clientDao.deleteById(id);
    }

    @Override
    public ResponseEntity<List<Compte>> findCompteClients(long idClient) {
        return clientDao.findById(idClient).map(
                c -> {

                    return ResponseEntity.ok(compteDao.findByClient(c));
                }
        ).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Compte> ajouterCompteClient(long idClient, CompteDto compteDto) {
        Compte compte = CompteDto.valueOf(compteDto);
        return clientDao.findById(idClient).map(
                c -> {
                    compte.setClient(c);
                    compteDao.save(compte);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(compte.getId())
                            .toUri();
                    return ResponseEntity.created(location).body(compte);
                }
        ).orElse(ResponseEntity.notFound().build());

    }

    @Override
    public ResponseEntity<Compte> modifierCompteClient(long idClient, long idCompte, CompteDto compteDto) {
        return compteDao.findByIdAndClientId(idCompte, idClient).map(
                c -> {
                    if(c instanceof CompteCourant){
                        ((CompteCourant) c).setFrais(compteDto.getFrais());
                    }else{
                        ((CompteEpargne)c).setMaturite(compteDto.getMaturite());
                        ((CompteEpargne)c).setTaux(compteDto.getTaux());
                    }
                    c.setDateCreation(compteDto.getDateCreation());
                    c.setNumero(compteDto.getNumero());
                    c.setSolde(compteDto.getSolde());
                    compteDao.save(c);
                    return ResponseEntity.ok(c);
                }
        ).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public void supprimerCompteClient(long idClient, long idCompte) {
        compteDao.findByIdAndClientId(idCompte, idClient).map(
                c ->{
                    compteDao.delete(c);
                    return 1;
                }
        );
    }

    @Override
    public ResponseEntity<Compte> renvoyerCompteClient(long idClient, long idCompte) {
        return compteDao.findByIdAndClientId(idCompte, idClient).map(
                c ->{                    
                    return ResponseEntity.ok(c);
                }
        ).orElse(ResponseEntity.notFound().build());
    }

}
