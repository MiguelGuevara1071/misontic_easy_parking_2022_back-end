/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.service.implement;

import com.easyparkingg7.dao.DetalleDao;
import com.easyparkingg7.model.Detalle;
import com.easyparkingg7.service.DetalleService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Guevara
 */

@Service
public class DetalleServiceImpl implements DetalleService {
    @Autowired
    private DetalleDao detalleDao;
    
    @Override
    @Transactional(readOnly=false)
    public Detalle save(Detalle detalle){
        return detalleDao.save(detalle);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        detalleDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Detalle findById(Integer id){
        return detalleDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Detalle> findAll(){
        return (List<Detalle>) detalleDao.findAll();
    }
}
