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
import com.example.demo.model.PedidoDetalle;
import com.example.demo.repository.PedidoDetalleRepository;

@RestController
@RequestMapping("/pedidoDetalles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoDetalleController {
	
	
	@Autowired
	PedidoDetalleRepository pedidoDetalleRepository;

	
    @GetMapping
    public List<PedidoDetalle> getRecetas() {
     return pedidoDetalleRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDetalle> getPedidoDetalleById(@PathVariable Long id) {
        Optional<PedidoDetalle> pedidoDetalleOptional = pedidoDetalleRepository.findById(id);
        return pedidoDetalleOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PedidoDetalle> createPedidoDetalle(@RequestBody PedidoDetalle pedidoDetalle) {
        PedidoDetalle savedPedidoDetalle = pedidoDetalleRepository.save(pedidoDetalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPedidoDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDetalle> updatePedidoDetalle(@PathVariable Long id,
                                                            @RequestBody PedidoDetalle updatedPedidoDetalle) {
        Optional<PedidoDetalle> existingPedidoDetalleOptional = pedidoDetalleRepository.findById(id);

        if (existingPedidoDetalleOptional.isPresent()) {
            PedidoDetalle existingPedidoDetalle = existingPedidoDetalleOptional.get();
            existingPedidoDetalle.setIdPedido(updatedPedidoDetalle.getIdPedido());
            existingPedidoDetalle.setIdMenu(updatedPedidoDetalle.getIdMenu());
            existingPedidoDetalle.setCantidad(updatedPedidoDetalle.getCantidad());
            existingPedidoDetalle.setTotal(updatedPedidoDetalle.getTotal());
            existingPedidoDetalle.setEstatus(updatedPedidoDetalle.getEstatus());

            PedidoDetalle updatedSavedPedidoDetalle = pedidoDetalleRepository.save(existingPedidoDetalle);
            return ResponseEntity.ok(updatedSavedPedidoDetalle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedidoDetalle(@PathVariable Long id) {
        if (pedidoDetalleRepository.existsById(id)) {
            pedidoDetalleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
