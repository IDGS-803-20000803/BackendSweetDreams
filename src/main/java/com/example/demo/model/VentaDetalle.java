package com.example.demo.model;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    private Long idVentaDetalle;
    private Long idVenta;
    private Long idMenu;
    private int cantidad;
    private BigDecimal total;
    private Byte estatus;

    // Constructor vacío
    public VentaDetalle() {
    }

    // Constructor lleno
    public VentaDetalle(Long idVenta, Long idMenu, int cantidad, BigDecimal total, Byte estatus) {
        this.idVenta = idVenta;
        this.idMenu = idMenu;
        this.cantidad = cantidad;
        this.total = total;
        this.estatus = estatus;
    }

    // Getters y setters

    public Long getIdVentaDetalle() {
        return idVentaDetalle;
    }

    public void setIdVentaDetalle(Long idVentaDetalle) {
        this.idVentaDetalle = idVentaDetalle;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Byte getEstatus() {
        return estatus;
    }

    public void setEstatus(Byte estatus) {
        this.estatus = estatus;
    }
}
