package com.example.demo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "id_metodoPago", nullable = false)
    private Long idMetodoPago;

    @Column(name = "estatus", nullable = false)
    private String estatus;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "total", precision = 10, scale = 3, nullable = false)
    private BigDecimal total;

    // Constructor vacío
    public Ventas() {
    }

    // Constructor lleno
    public Ventas(Long idCliente, Long idMetodoPago, String estatus,
                 Date fechaCreacion, Date fechaModificacion, BigDecimal total) {
        this.idCliente = idCliente;
        this.idMetodoPago = idMetodoPago;
        this.estatus = estatus;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.total = total;
    }

    // Getters y setters

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

