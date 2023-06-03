/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.service;

import com.easyparkingg7.model.Plaza;
import java.util.List;

/**
 *
 * @author Miguel Guevara
 */

public interface PlazaService {
    public Plaza save(Plaza plaza);
    public void delete(Integer id);
    public Plaza findById(Integer id);
    public List<Plaza> findAll();
}
