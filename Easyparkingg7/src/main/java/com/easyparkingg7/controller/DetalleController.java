/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.controller;

import com.easyparkingg7.model.Detalle;
import com.easyparkingg7.service.DetalleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Guevara
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/detalle")
public class DetalleController {
    @Autowired
    private DetalleService detalleservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Detalle> agregar(@RequestBody Detalle detalle){
        Detalle obj = detalleservice.save(detalle);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Detalle> eliminar(@PathVariable Integer id){
        Detalle obj = detalleservice.findById(id);
        if(obj!=null)
            detalleservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Detalle> editar(@RequestBody Detalle detalle){
    Detalle obj = detalleservice.findById(detalle.getId_detalle());
    if(obj!=null){
        obj.setPlaza(detalle.getPlaza());
        obj.setFactura(detalle.getFactura());
        obj.setValor_pago(detalle.getValor_pago());
        detalleservice.save(obj);
    } else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Detalle> consultarTodo(){
        return detalleservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Detalle consultaPorId(@PathVariable Integer id){
        return detalleservice.findById(id);
    }
}
