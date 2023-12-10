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
import com.example.demo.model.Ventas;
import com.example.demo.repository.VentasRepository;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VentasController {
	
	@Autowired
	VentasRepository ventasRepository;
	
    @GetMapping
    public List<Ventas> getRecetas() {
     return ventasRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ventas> getVentaById(@PathVariable Long id) {
        Optional<Ventas> ventaOptional = ventasRepository.findById(id);
        return ventaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ventas> createVenta(@RequestBody Ventas venta) {
        Ventas savedVenta = ventasRepository.save(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> updateVenta(@PathVariable Long id, @RequestBody Ventas updatedVenta) {
        Optional<Ventas> existingVentaOptional = ventasRepository.findById(id);

        if (existingVentaOptional.isPresent()) {
            Ventas existingVenta = existingVentaOptional.get();
            existingVenta.setIdCliente(updatedVenta.getIdCliente());
            existingVenta.setIdMetodoPago(updatedVenta.getIdMetodoPago());
            existingVenta.setEstatus(updatedVenta.getEstatus());
            existingVenta.setFechaCreacion(updatedVenta.getFechaCreacion());
            existingVenta.setFechaModificacion(updatedVenta.getFechaModificacion());
            existingVenta.setTotal(updatedVenta.getTotal());

            Ventas updatedSavedVenta = ventasRepository.save(existingVenta);
            return ResponseEntity.ok(updatedSavedVenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        if (ventasRepository.existsById(id)) {
            ventasRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
