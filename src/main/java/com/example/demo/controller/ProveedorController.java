package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Menu;
import com.example.demo.model.Proveedor;
import com.example.demo.repository.ProveedorRepository;

@RestController
@RequestMapping("/proveedores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProveedorController {

	@Autowired
	ProveedorRepository proveedorRepository;
	
	
    @GetMapping
    public List<Proveedor> getRecetas() {
     return proveedorRepository.findAll();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable(value = "id") Integer id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);

        if (proveedor.isPresent()) {
            return ResponseEntity.ok().body(proveedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable(value = "id") Integer id,
                                                         @RequestBody Proveedor proveedorDetails) {
        Optional<Proveedor> optionalProveedor = proveedorRepository.findById(id);

        if (optionalProveedor.isPresent()) {
            Proveedor proveedor = optionalProveedor.get();
            proveedor.setRazonSocial(proveedorDetails.getRazonSocial());
            proveedor.setRfc(proveedorDetails.getRfc());
            proveedor.setCelular(proveedorDetails.getCelular());
            proveedor.setCodigoPostal(proveedorDetails.getCodigoPostal());
            proveedor.setCalle(proveedorDetails.getCalle());
            proveedor.setColonia(proveedorDetails.getColonia());
            proveedor.setEstatus(proveedorDetails.getEstatus());

            Proveedor proveedorActualizado = proveedorRepository.save(proveedor);
            return ResponseEntity.ok().body(proveedorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable(value = "id") Integer id) {
        Optional<Proveedor> optionalProveedor = proveedorRepository.findById(id);

        if (optionalProveedor.isPresent()) {
            proveedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
}
