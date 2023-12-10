package com.example.demo.model;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class EntradaInventario {
	
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private Long idEntrada;

    @Column(name = "id_ingrediente", nullable = false)
    private int idIngrediente;

    @Column(name = "unidadMedida")
    private String unidadMedida;

    @Column(name = "cantidad", precision = 10, scale = 3)
    private BigDecimal cantidad;

    @Column(name = "fecha_entrada")
    private Date fechaEntrada;

    @Column(name = "id_usuario")
    private Long idUsuario;

    // Constructor vacío
    public EntradaInventario() {
    }

    // Constructor lleno
    public EntradaInventario(int idIngrediente, String unidadMedida, BigDecimal cantidad,
                              Date fechaEntrada, Long idUsuario) {
        this.idIngrediente = idIngrediente;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.fechaEntrada = fechaEntrada;
        this.idUsuario = idUsuario;
    }

    // Getters y setters

    public Long getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Long idEntrada) {
        this.idEntrada = idEntrada;
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

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

	public static Optional<EntradaInventario> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}

