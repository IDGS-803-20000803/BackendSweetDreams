package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;
    private int idIngrediente;
    private int idUsuario;
    private int existenciaInicial;
    private int existenciaActual;
    private String unidadMedida;
    private Date fechaEntrada;
    private Date fechaModificacion;


    public Inventario() {
    }


    public Inventario(int idIngrediente, int idUsuario, int existenciaInicial,
                      int existenciaActual, String unidadMedida, Date fechaEntrada,
                      Date fechaModificacion) {
        this.idIngrediente = idIngrediente;
        this.idUsuario = idUsuario;
        this.existenciaInicial = existenciaInicial;
        this.existenciaActual = existenciaActual;
        this.unidadMedida = unidadMedida;
        this.fechaEntrada = fechaEntrada;
        this.fechaModificacion = fechaModificacion;
    }

    // Getters y setters

    public Long getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Long idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getExistenciaInicial() {
        return existenciaInicial;
    }

    public void setExistenciaInicial(int existenciaInicial) {
        this.existenciaInicial = existenciaInicial;
    }

    public int getExistenciaActual() {
        return existenciaActual;
    }

    public void setExistenciaActual(int existenciaActual) {
        this.existenciaActual = existenciaActual;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
