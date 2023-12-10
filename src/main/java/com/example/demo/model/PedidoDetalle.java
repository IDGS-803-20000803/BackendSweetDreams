package com.example.demo.model;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_detalle")
    private Long idPedidoDetalle;

    @Column(name = "id_pedido", nullable = false)
    private Long idPedido;

    @Column(name = "id_menu", nullable = false)
    private Long idMenu;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "total", precision = 10, scale = 3)
    private BigDecimal total;

    @Column(name = "estatus")
    private Byte estatus;

    // Constructor vacío
    public PedidoDetalle() {
    }

    // Constructor lleno
    public PedidoDetalle(Long idPedido, Long idMenu, int cantidad, BigDecimal total, Byte estatus) {
        this.idPedido = idPedido;
        this.idMenu = idMenu;
        this.cantidad = cantidad;
        this.total = total;
        this.estatus = estatus;
    }

    // Getters y setters

    public Long getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(Long idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
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
