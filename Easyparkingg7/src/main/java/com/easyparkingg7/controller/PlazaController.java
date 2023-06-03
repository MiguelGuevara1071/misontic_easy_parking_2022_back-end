/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.controller;

import com.easyparkingg7.model.Plaza;
import com.easyparkingg7.service.PlazaService;
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
@RequestMapping("/plaza")
public class PlazaController {
    @Autowired
    private PlazaService plazaservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Plaza> agregar(@RequestBody Plaza plaza){
        Plaza obj = plazaservice.save(plaza);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Plaza> eliminar(@PathVariable Integer id){
        Plaza obj = plazaservice.findById(id);
        if(obj!=null)
            plazaservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Plaza> editar(@RequestBody Plaza plaza){
    Plaza obj = plazaservice.findById(plaza.getId_plaza());
    if(obj!=null){
        obj.setCodigo_plaza(plaza.getCodigo_plaza());
        obj.setEstado(plaza.getEstado());
        plazaservice.save(obj);
    } else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Plaza> consultarTodo(){
        return plazaservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Plaza consultaPorId(@PathVariable Integer id){
        return plazaservice.findById(id);
    }
}
