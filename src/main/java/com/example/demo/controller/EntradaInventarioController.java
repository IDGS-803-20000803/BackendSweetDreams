package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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

import com.example.demo.model.EntradaInventario;

import com.example.demo.repository.EntradaInventarioRepository;

@RestController
@RequestMapping("/entradainventarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EntradaInventarioController {
	
	@Autowired
	EntradaInventarioRepository entradaInvetarioRepository;
	
    @GetMapping
    public List<EntradaInventario> getRecetas() {
     return entradaInvetarioRepository.findAll();
    }
	
    
    @GetMapping("/{id}")
    public ResponseEntity<EntradaInventario> getEntradaInventarioById(@PathVariable Long id) {
        Optional<EntradaInventario> entradaInventarioOptional = entradaInvetarioRepository.findById(id);
        return entradaInventarioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntradaInventario> createEntradaInventario(@RequestBody EntradaInventario entradaInventario) {
        EntradaInventario savedEntradaInventario = entradaInvetarioRepository.save(entradaInventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntradaInventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaInventario> updateEntradaInventario(@PathVariable Long id,
                                                                    @RequestBody EntradaInventario updatedEntradaInventario) {
        Optional<EntradaInventario> existingEntradaInventarioOptional = entradaInvetarioRepository.findById(id);

        if (existingEntradaInventarioOptional.isPresent()) {
            EntradaInventario existingEntradaInventario = existingEntradaInventarioOptional.get();
            existingEntradaInventario.setIdIngrediente(updatedEntradaInventario.getIdIngrediente());
            existingEntradaInventario.setUnidadMedida(updatedEntradaInventario.getUnidadMedida());
            existingEntradaInventario.setCantidad(updatedEntradaInventario.getCantidad());
            existingEntradaInventario.setFechaEntrada(updatedEntradaInventario.getFechaEntrada());
            existingEntradaInventario.setIdUsuario(updatedEntradaInventario.getIdUsuario());

            EntradaInventario updatedSavedEntradaInventario = entradaInvetarioRepository.save(existingEntradaInventario);
            return ResponseEntity.ok(updatedSavedEntradaInventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntradaInventario(@PathVariable Long id) {
        if (entradaInvetarioRepository.existsById(id)) {
            entradaInvetarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	

}
