package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proveedor {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idProveedor;
	    private String razonSocial;
	    private String rfc;
	    private String celular;
	    private String codigoPostal;
	    private String calle;
	    private String colonia;
	    private Boolean estatus;

	  
	    public Proveedor() {
	    }

	
	    public Proveedor(String razonSocial, String rfc, String celular, String codigoPostal, String calle, String colonia, Boolean estatus) {
	        this.razonSocial = razonSocial;
	        this.rfc = rfc;
	        this.celular = celular;
	        this.codigoPostal = codigoPostal;
	        this.calle = calle;
	        this.colonia = colonia;
	        this.estatus = estatus;
	    }

	
	    public Integer getIdProveedor() {
	        return idProveedor;
	    }

	    public void setIdProveedor(Integer idProveedor) {
	        this.idProveedor = idProveedor;
	    }

	    public String getRazonSocial() {
	        return razonSocial;
	    }

	    public void setRazonSocial(String razonSocial) {
	        this.razonSocial = razonSocial;
	    }

	    public String getRfc() {
	        return rfc;
	    }

	    public void setRfc(String rfc) {
	        this.rfc = rfc;
	    }

	    public String getCelular() {
	        return celular;
	    }

	    public void setCelular(String celular) {
	        this.celular = celular;
	    }

	    public String getCodigoPostal() {
	        return codigoPostal;
	    }

	    public void setCodigoPostal(String codigoPostal) {
	        this.codigoPostal = codigoPostal;
	    }

	    public String getCalle() {
	        return calle;
	    }

	    public void setCalle(String calle) {
	        this.calle = calle;
	    }

	    public String getColonia() {
	        return colonia;
	    }

	    public void setColonia(String colonia) {
	        this.colonia = colonia;
	    }

	    public Boolean getEstatus() {
	        return estatus;
	    }

	    public void setEstatus(Boolean estatus) {
	        this.estatus = estatus;
	    }

}
