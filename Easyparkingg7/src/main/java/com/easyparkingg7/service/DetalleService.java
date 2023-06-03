/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.service;

import com.easyparkingg7.model.Detalle;
import java.util.List;

/**
 *
 * @author Miguel Guevara
 */
public interface DetalleService {
    public Detalle save(Detalle detalle);
    public void delete(Integer id);
    public Detalle findById(Integer id);
    public List<Detalle> findAll();
}
