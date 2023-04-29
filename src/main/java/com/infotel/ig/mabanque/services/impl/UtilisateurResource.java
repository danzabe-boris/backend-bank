package com.infotel.ig.mabanque.services.impl;

import com.infotel.ig.mabanque.dao.UtilisateurDao;
import com.infotel.ig.mabanque.entities.Utilisateur;
import com.infotel.ig.mabanque.services.IUtilisateurResource;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author HP
 */
public class UtilisateurResource implements IUtilisateurResource{

    @Autowired
    private UtilisateurDao utilisateurDao;
    
    @Override
    public ResponseEntity<Page<Utilisateur>> findAllUtilisateurs(int page, int size) {
        return ResponseEntity.ok(utilisateurDao.findAll(PageRequest.of(page, size)));
    }

    @Override
    public ResponseEntity<Utilisateur> addUtilisateur(Utilisateur user) {
        Utilisateur u = utilisateurDao.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(u.getId())
                .toUri();
        return ResponseEntity.created(location).body(u);
    }

    @Override
    public ResponseEntity<Utilisateur> findUtilisateur(long id) {
        return utilisateurDao.findById(id).map(
                u -> {
                    return ResponseEntity.ok(u);
                }
        ).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Utilisateur> updateUtilisateur(long id, Utilisateur user) {
        return utilisateurDao.findById(id).map(
                u -> {
                    u.setEmail(user.getEmail());
                    u.setNom(user.getNom());
                    u.setPassword(user.getPassword());
                    u.setRole(user.getRole());
                    return ResponseEntity.ok(utilisateurDao.save(u));
                }
        ).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public void deleteUtilisateur(long id) {
        utilisateurDao.deleteById(id);
    }
    
}
