/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.service.implement;

import com.easyparkingg7.dao.PlazaDao;
import com.easyparkingg7.model.Plaza;
import com.easyparkingg7.service.PlazaService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Guevara
 */

@Service
public class PlazaServiceImpl implements PlazaService{
    @Autowired
    private PlazaDao plazaDao;
    
    @Override
    @Transactional(readOnly=false)
    public Plaza save(Plaza plaza){
        return plazaDao.save(plaza);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        plazaDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Plaza findById(Integer id){
        return plazaDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Plaza> findAll(){
        return (List<Plaza>) plazaDao.findAll();
    }
}
