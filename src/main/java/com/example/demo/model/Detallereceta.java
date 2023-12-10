package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
public class Detallereceta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idDetalleReceta;
    private Integer idReceta;
    private Integer idIngrediente;
    private Integer cantidad;
    private String descripcion;
    private Boolean estatus;

    public Detallereceta() {
    }

    public Detallereceta(Integer idReceta, Integer idIngrediente, Integer cantidad, String descripcion, Boolean estatus) {
        this.idReceta = idReceta;
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public Integer getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public void setIdDetalleReceta(Integer idDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }
}
