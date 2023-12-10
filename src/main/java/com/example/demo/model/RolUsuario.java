package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RolUsuario {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idRolUsuario;
	    private Integer idUsuario;
	    private Integer idRol;

	    public RolUsuario() {
	    }

	    public RolUsuario(Integer idUsuario, Integer idRol) {
	        this.idUsuario = idUsuario;
	        this.idRol = idRol;
	    }

	    public Integer getIdRolUsuario() {
	        return idRolUsuario;
	    }

	    public void setIdRolUsuario(Integer idRolUsuario) {
	        this.idRolUsuario = idRolUsuario;
	    }

	    public Integer getIdUsuario() {
	        return idUsuario;
	    }

	    public void setIdUsuario(Integer idUsuario) {
	        this.idUsuario = idUsuario;
	    }

	    public Integer getIdRol() {
	        return idRol;
	    }

	    public void setIdRol(Integer idRol) {
	        this.idRol = idRol;
	    }

}
