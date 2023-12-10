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

import com.example.demo.model.CompraDetalle;
import com.example.demo.model.Inventario;
import com.example.demo.repository.CompraDetalleRepository;
import com.example.demo.repository.CompraRepository;

@RestController
@RequestMapping("/compradetalles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompraDetalleController {
	
	@Autowired
	CompraDetalleRepository compraDetalleRepository;
	
    @GetMapping
    public List<CompraDetalle> getRecetas() {
     return compraDetalleRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CompraDetalle> getCompraDetalleById(@PathVariable Long id) {
        Optional<CompraDetalle> compraDetalleOptional = compraDetalleRepository.findById(id);
        return compraDetalleOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CompraDetalle> createCompraDetalle(@RequestBody CompraDetalle compraDetalle) {
        CompraDetalle savedCompraDetalle = compraDetalleRepository.save(compraDetalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompraDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompraDetalle> updateCompraDetalle(@PathVariable Long id,
                                                            @RequestBody CompraDetalle updatedCompraDetalle) {
        Optional<CompraDetalle> existingCompraDetalleOptional = compraDetalleRepository.findById(id);

        if (existingCompraDetalleOptional.isPresent()) {
            CompraDetalle existingCompraDetalle = existingCompraDetalleOptional.get();
            existingCompraDetalle.setIdCompra(updatedCompraDetalle.getIdCompra());
            existingCompraDetalle.setIdIngrediente(updatedCompraDetalle.getIdIngrediente());
            existingCompraDetalle.setUnidadMedida(updatedCompraDetalle.getUnidadMedida());
            existingCompraDetalle.setCantidad(updatedCompraDetalle.getCantidad());
            existingCompraDetalle.setPrecioUnitario(updatedCompraDetalle.getPrecioUnitario());
            existingCompraDetalle.setTotal(updatedCompraDetalle.getTotal());
            existingCompraDetalle.setEstatus(updatedCompraDetalle.getEstatus());

            CompraDetalle updatedSavedCompraDetalle = compraDetalleRepository.save(existingCompraDetalle);
            return ResponseEntity.ok(updatedSavedCompraDetalle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompraDetalle(@PathVariable Long id) {
        if (compraDetalleRepository.existsById(id)) {
            compraDetalleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
