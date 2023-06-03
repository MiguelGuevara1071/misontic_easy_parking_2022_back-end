/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.service;

import com.easyparkingg7.model.Factura;
import java.util.List;

/**
 *
 * @author Miguel Guevara
 */

public interface FacturaService {
    public Factura save(Factura factura);
    public void delete(Integer id);
    public Factura findById(Integer id);
    public List<Factura> findAll();
}
