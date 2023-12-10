package com.example.demo.model;


import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "id_metodo_pago")
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
    public Pedido() {
    }

    // Constructor lleno
    public Pedido(Long idCliente, Long idMetodoPago, String estatus,
                  Date fechaCreacion, Date fechaModificacion, BigDecimal total) {
        this.idCliente = idCliente;
        this.idMetodoPago = idMetodoPago;
        this.estatus = estatus;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.total = total;
    }

    // Getters y setters

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
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

