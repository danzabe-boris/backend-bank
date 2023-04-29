package com.infotel.ig.mabanque.services.impl;

import com.infotel.ig.mabanque.dao.OperationDao;
import com.infotel.ig.mabanque.entities.Operation;
import com.infotel.ig.mabanque.entities.TypeOperation;
import com.infotel.ig.mabanque.services.IOperationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author HP
 */
public class OperationResource implements IOperationResource{

    @Autowired
    private OperationDao operationDao;
    
    @Override
    public ResponseEntity<Page<Operation>> getAllOperation(TypeOperation type, int page, int size) {
        if (type != null){
            return ResponseEntity.ok(operationDao.findByTypeOperation(type, PageRequest.of(page, size)));
        } 
        return ResponseEntity.ok(operationDao.findAll(PageRequest.of(page, size)));
    }
    
}
