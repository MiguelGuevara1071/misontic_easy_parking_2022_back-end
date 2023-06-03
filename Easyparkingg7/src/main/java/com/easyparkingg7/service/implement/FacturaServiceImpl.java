/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.service.implement;

import com.easyparkingg7.dao.FacturaDao;
import com.easyparkingg7.model.Factura;
import com.easyparkingg7.service.FacturaService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Guevara
 */

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaDao facturaDao;
    
    @Override
    @Transactional(readOnly=false)
    public Factura save(Factura factura){
        return facturaDao.save(factura);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        facturaDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Factura findById(Integer id){
        return facturaDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Factura> findAll(){
        return (List<Factura>) facturaDao.findAll();
    }
}
