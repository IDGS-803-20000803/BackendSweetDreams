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

import com.example.demo.model.Clientes;
import com.example.demo.model.Inventario;
import com.example.demo.repository.InventarioRepository;

@RestController
@RequestMapping("/inventarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InventarioController {
	
	@Autowired
	InventarioRepository inventarioRepository;
	
    @GetMapping
    public List<Inventario> getRecetas() {
     return inventarioRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Long id) {
        Optional<Inventario> inventarioOptional = inventarioRepository.findById(id);
        return inventarioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inventario> createInventario(@RequestBody Inventario inventario) {
        Inventario savedInventario = inventarioRepository.save(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable Long id, @RequestBody Inventario updatedInventario) {
        Optional<Inventario> existingInventarioOptional = inventarioRepository.findById(id);

        if (existingInventarioOptional.isPresent()) {
            Inventario existingInventario = existingInventarioOptional.get();
            existingInventario.setIdIngrediente(updatedInventario.getIdIngrediente());
            existingInventario.setIdUsuario(updatedInventario.getIdUsuario());
            existingInventario.setExistenciaInicial(updatedInventario.getExistenciaInicial());
            existingInventario.setExistenciaActual(updatedInventario.getExistenciaActual());
            existingInventario.setUnidadMedida(updatedInventario.getUnidadMedida());
            existingInventario.setFechaEntrada(updatedInventario.getFechaEntrada());
            existingInventario.setFechaModificacion(updatedInventario.getFechaModificacion());

            Inventario updatedSavedInventario = inventarioRepository.save(existingInventario);
            return ResponseEntity.ok(updatedSavedInventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id) {
        if (inventarioRepository.existsById(id)) {
            inventarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
