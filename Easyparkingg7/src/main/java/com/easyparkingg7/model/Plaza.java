/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyparkingg7.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Miguel Guevara
 */

@Entity
@Table(name="plazas")
 
public class Plaza implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_plaza")
    private Integer id_plaza;
    
    @Column(name="codigo_plaza")
    private String codigo_plaza;
    
    @Column(name="estado")
    private String estado;

    public Integer getId_plaza() {
        return id_plaza;
    }

    public void setId_plaza(Integer id_plaza) {
        this.id_plaza = id_plaza;
    }

    public String getCodigo_plaza() {
        return codigo_plaza;
    }

    public void setCodigo_plaza(String codigo_plaza) {
        this.codigo_plaza = codigo_plaza;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
