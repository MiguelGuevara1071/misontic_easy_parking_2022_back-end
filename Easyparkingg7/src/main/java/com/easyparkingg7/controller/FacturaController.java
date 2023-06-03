/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.controller;

import com.easyparkingg7.model.Factura;
import com.easyparkingg7.service.FacturaService;
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
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private FacturaService facturaservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Factura> agregar(@RequestBody Factura factura){
        Factura obj = facturaservice.save(factura);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Factura> eliminar(@PathVariable Integer id){
        Factura obj = facturaservice.findById(id);
        if(obj!=null)
            facturaservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Factura> editar(@RequestBody Factura factura){
    Factura obj = facturaservice.findById(factura.getId_factura());
    if(obj!=null){
        obj.setFecha_ingreso(factura.getFecha_ingreso());
        obj.setHora_entrada(factura.getHora_entrada());
        obj.setHora_salida(factura.getHora_salida());
        obj.setTipo_vehiculo(factura.getTipo_vehiculo());
        obj.setPlaca_vehiculo(factura.getPlaca_vehiculo());
        facturaservice.save(obj);
    } else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Factura> consultarTodo(){
        return facturaservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Factura consultaPorId(@PathVariable Integer id){
        return facturaservice.findById(id);
    }
}
