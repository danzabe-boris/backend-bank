package com.infotel.ig.mabanque.services.impl;

import com.infotel.ig.mabanque.dao.CompteDao;
import com.infotel.ig.mabanque.dao.OperationDao;
import com.infotel.ig.mabanque.entities.Compte;
import com.infotel.ig.mabanque.entities.Operation;
import com.infotel.ig.mabanque.services.ICompteResource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author HP
 */
public class CompteResource implements ICompteResource{

    
    @Autowired
    private CompteDao compteDao;
    
    @Autowired
    private OperationDao operationDao;
    
    @Override
    public ResponseEntity<Page<Compte>> getAllComptes(int page, int pagesize) {
        return ResponseEntity.ok(compteDao.findAll(PageRequest.of(page, pagesize)));
    }

    @Override
    public ResponseEntity<Compte> findCompte(long id) {
        return compteDao.findById(id).map(
                c -> {
                    
                    return ResponseEntity.ok(c);
                }
        ).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Compte> searchCompte(String numero) {
        return compteDao.findByNumero(numero).map(
                c -> {
                    
                    return ResponseEntity.ok(c);
                }
        ).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Operation>> getAllOperationsCompte(long id) {
        
        return compteDao.findById(id).map(
                c -> {
                    
                    return ResponseEntity.ok(operationDao.findByCompte(c));
                }
        ).orElse(ResponseEntity.notFound().build()); 
    }
    
}
