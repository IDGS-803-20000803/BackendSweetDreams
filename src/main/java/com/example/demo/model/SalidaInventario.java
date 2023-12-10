package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SalidaInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salida")
    private Long idSalida;

    @Column(name = "id_ingrediente", nullable = false)
    private int idIngrediente;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "cantidad", precision = 10, scale = 3)
    private BigDecimal cantidad;

    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @Column(name = "id_usuario")
    private Long idUsuario;

    // Constructor vacío
    public SalidaInventario() {
    }

    // Constructor lleno
    public SalidaInventario(int idIngrediente, String unidadMedida, BigDecimal cantidad,
                            Date fechaSalida, Long idUsuario) {
        this.idIngrediente = idIngrediente;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.fechaSalida = fechaSalida;
        this.idUsuario = idUsuario;
    }

    // Getters y setters

    public Long getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Long idSalida) {
        this.idSalida = idSalida;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
