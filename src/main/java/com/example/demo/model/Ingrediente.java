package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngrediente;
    private String nombre;
    private String unidadMedida;
    private Integer cantidadMedida;
    private Boolean estatus;

    public Ingrediente() {
    }


    public Ingrediente(String nombre, String unidadMedida, Integer cantidadMedida, Boolean estatus) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadMedida = cantidadMedida;
        this.estatus = estatus;
    }


	public Integer getIdIngrediente() {
		return idIngrediente;
	}


	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUnidadMedida() {
		return unidadMedida;
	}


	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}


	public Integer getCantidadMedida() {
		return cantidadMedida;
	}


	public void setCantidadMedida(Integer cantidadMedida) {
		this.cantidadMedida = cantidadMedida;
	}


	public Boolean getEstatus() {
		return estatus;
	}


	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
    
    
    
    
	
}
