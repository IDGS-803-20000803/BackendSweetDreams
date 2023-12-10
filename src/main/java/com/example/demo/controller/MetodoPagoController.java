package com.example.demo.controller;

import java.util.List;

import org.apache.el.stream.Optional;
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
import com.example.demo.model.MetodoPago;
import com.example.demo.repository.MetodoPagoRepository;

@RestController
@RequestMapping("/metodopagos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MetodoPagoController {

	@Autowired
	MetodoPagoRepository metodoPagoRepository;
	
    @GetMapping
    public List<MetodoPago> getRecetas() {
     return metodoPagoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getMetodoPagoById(@PathVariable Long id) {
        java.util.Optional<MetodoPago> metodoPagoOptional = metodoPagoRepository.findById(id);
        return metodoPagoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MetodoPago> createMetodoPago(@RequestBody MetodoPago metodoPago) {
        MetodoPago savedMetodoPago = metodoPagoRepository.save(metodoPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMetodoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> updateMetodoPago(@PathVariable Long id,
                                                       @RequestBody MetodoPago updatedMetodoPago) {
        java.util.Optional<MetodoPago> existingMetodoPagoOptional = metodoPagoRepository.findById(id);

        if (existingMetodoPagoOptional.isPresent()) {
            MetodoPago existingMetodoPago = existingMetodoPagoOptional.get();
            existingMetodoPago.setMetodoPago(updatedMetodoPago.getMetodoPago());
            existingMetodoPago.setEstatus(updatedMetodoPago.getEstatus());

            MetodoPago updatedSavedMetodoPago = metodoPagoRepository.save(existingMetodoPago);
            return ResponseEntity.ok(updatedSavedMetodoPago);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable Long id) {
        if (metodoPagoRepository.existsById(id)) {
            metodoPagoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
