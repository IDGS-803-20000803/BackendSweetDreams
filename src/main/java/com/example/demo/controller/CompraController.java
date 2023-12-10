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

import com.example.demo.model.Compra;
import com.example.demo.model.Inventario;
import com.example.demo.repository.CompraRepository;

@RestController
@RequestMapping("/compras")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompraController {
	
	@Autowired
	CompraRepository compraRepository;
	
    @GetMapping
    public List<Compra> getRecetas() {
     return compraRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable Long id) {
        Optional<Compra> compraOptional = compraRepository.findById(id);
        return compraOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Compra> createCompra(@RequestBody Compra compra) {
        Compra savedCompra = compraRepository.save(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable Long id, @RequestBody Compra updatedCompra) {
        Optional<Compra> existingCompraOptional = compraRepository.findById(id);

        if (existingCompraOptional.isPresent()) {
            Compra existingCompra = existingCompraOptional.get();
            existingCompra.setIdProveedor(updatedCompra.getIdProveedor());
            existingCompra.setIdMetodoPago(updatedCompra.getIdMetodoPago());
            existingCompra.setIdUsuario(updatedCompra.getIdUsuario());
            existingCompra.setTotalCompra(updatedCompra.getTotalCompra());
            existingCompra.setFechaCreacion(updatedCompra.getFechaCreacion());
            existingCompra.setEstatus(updatedCompra.getEstatus());

            Compra updatedSavedCompra = compraRepository.save(existingCompra);
            return ResponseEntity.ok(updatedSavedCompra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Long id) {
        if (compraRepository.existsById(id)) {
            compraRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
