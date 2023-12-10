package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.model.Inventario;
import com.example.demo.model.VentaDetalle;
import com.example.demo.repository.VentaDetalleRepository;

@RestController
@RequestMapping("/ventadetalles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VentaDetalleController {
	
	@Autowired
	VentaDetalleRepository ventaDetalleRepository;
	
    @GetMapping
    public List<VentaDetalle> getRecetas() {
     return ventaDetalleRepository.findAll();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<VentaDetalle> getVentaDetalleById(@PathVariable Long id) {
        Optional<VentaDetalle> ventaDetalleOptional = ventaDetalleRepository.findById(id);
        return ventaDetalleOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VentaDetalle> createVentaDetalle(@RequestBody VentaDetalle ventaDetalle) {
        VentaDetalle savedVentaDetalle = ventaDetalleRepository.save(ventaDetalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVentaDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaDetalle> updateVentaDetalle(@PathVariable Long id,
                                                          @RequestBody VentaDetalle updatedVentaDetalle) {
        Optional<VentaDetalle> existingVentaDetalleOptional = ventaDetalleRepository.findById(id);

        if (existingVentaDetalleOptional.isPresent()) {
            VentaDetalle existingVentaDetalle = existingVentaDetalleOptional.get();
            existingVentaDetalle.setIdVenta(updatedVentaDetalle.getIdVenta());
            existingVentaDetalle.setIdMenu(updatedVentaDetalle.getIdMenu());
            existingVentaDetalle.setCantidad(updatedVentaDetalle.getCantidad());
            existingVentaDetalle.setTotal(updatedVentaDetalle.getTotal());
            existingVentaDetalle.setEstatus(updatedVentaDetalle.getEstatus());

            VentaDetalle updatedSavedVentaDetalle = ventaDetalleRepository.save(existingVentaDetalle);
            return ResponseEntity.ok(updatedSavedVentaDetalle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVentaDetalle(@PathVariable Long id) {
        if (ventaDetalleRepository.existsById(id)) {
            ventaDetalleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
	

}
