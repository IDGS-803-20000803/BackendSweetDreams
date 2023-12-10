package com.example.demo.model;


import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_proveedor", nullable = false)
    private Long idProveedor;

    @Column(name = "id_metodo_pago", nullable = false)
    private Long idMetodoPago;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "total_compra", precision = 10, scale = 3, nullable = false)
    private BigDecimal totalCompra;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "estatus")
    private String estatus;

    // Constructor vacío
    public Compra() {
    }

    // Constructor lleno
    public Compra(Long idProveedor, Long idMetodoPago, Long idUsuario,
                  BigDecimal totalCompra, Date fechaCreacion, String estatus) {
        this.idProveedor = idProveedor;
        this.idMetodoPago = idMetodoPago;
        this.idUsuario = idUsuario;
        this.totalCompra = totalCompra;
        this.fechaCreacion = fechaCreacion;
        this.estatus = estatus;
    }

    // Getters y setters

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}

