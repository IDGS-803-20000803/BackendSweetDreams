package com.example.demo.model;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompraDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra_detalle")
    private Long idCompraDetalle;

    @Column(name = "id_compra", nullable = false)
    private Long idCompra;

    @Column(name = "id_ingrediente", nullable = false)
    private Long idIngrediente;

    @Column(name = "unidad_medida", nullable = false)
    private String unidadMedida;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_unitario", precision = 10, scale = 3)
    private BigDecimal precioUnitario;

    @Column(name = "total", precision = 10, scale = 3)
    private BigDecimal total;

    @Column(name = "estatus")
    private String estatus;

    // Constructor vacío
    public CompraDetalle() {
    }

    // Constructor lleno
    public CompraDetalle(Long idCompra, Long idIngrediente, String unidadMedida,
                         int cantidad, BigDecimal precioUnitario, BigDecimal total, String estatus) {
        this.idCompra = idCompra;
        this.idIngrediente = idIngrediente;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = total;
        this.estatus = estatus;
    }

    // Getters y setters

    public Long getIdCompraDetalle() {
        return idCompraDetalle;
    }

    public void setIdCompraDetalle(Long idCompraDetalle) {
        this.idCompraDetalle = idCompraDetalle;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
