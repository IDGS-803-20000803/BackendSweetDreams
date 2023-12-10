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
import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
    @GetMapping
    public List<Pedido> getRecetas() {
     return pedidoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        return pedidoOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido savedPedido = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido updatedPedido) {
        Optional<Pedido> existingPedidoOptional = pedidoRepository.findById(id);

        if (existingPedidoOptional.isPresent()) {
            Pedido existingPedido = existingPedidoOptional.get();
            existingPedido.setIdCliente(updatedPedido.getIdCliente());
            existingPedido.setIdMetodoPago(updatedPedido.getIdMetodoPago());
            existingPedido.setEstatus(updatedPedido.getEstatus());
            existingPedido.setFechaCreacion(updatedPedido.getFechaCreacion());
            existingPedido.setFechaModificacion(updatedPedido.getFechaModificacion());
            existingPedido.setTotal(updatedPedido.getTotal());

            Pedido updatedSavedPedido = pedidoRepository.save(existingPedido);
            return ResponseEntity.ok(updatedSavedPedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
