package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReceta;

    private String nombreReceta;
    private Integer tiempoDuracion;
    private Boolean estatus;

    public Receta() {
    }

    public Receta(String nombreReceta, Integer tiempoDuracion, Boolean estatus) {
        this.nombreReceta = nombreReceta;
        this.tiempoDuracion = tiempoDuracion;
        this.estatus = estatus;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public Integer getTiempoDuracion() {
        return tiempoDuracion;
    }

    public void setTiempoDuracion(Integer tiempoDuracion) {
        this.tiempoDuracion = tiempoDuracion;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }
}

