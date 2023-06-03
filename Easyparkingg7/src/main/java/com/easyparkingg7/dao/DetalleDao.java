/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.dao;

import com.easyparkingg7.model.Detalle;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Miguel Guevara
 */

public interface DetalleDao extends CrudRepository<Detalle,Integer>{
    
}
