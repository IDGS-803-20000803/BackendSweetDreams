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


import com.example.demo.model.SalidaInventario;
import com.example.demo.repository.SalidaInventarioRepository;

@RestController
@RequestMapping("/salidainventarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalidaInventariController {
	
	@Autowired
	SalidaInventarioRepository salidaInventarioRepository;
	
	
    @GetMapping
    public List<SalidaInventario> getRecetas() {
     return salidaInventarioRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SalidaInventario> getSalidaInventarioById(@PathVariable Long id) {
        Optional<SalidaInventario> salidaInventarioOptional = salidaInventarioRepository.findById(id);
        return salidaInventarioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalidaInventario> createSalidaInventario(@RequestBody SalidaInventario salidaInventario) {
        SalidaInventario savedSalidaInventario = salidaInventarioRepository.save(salidaInventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSalidaInventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalidaInventario> updateSalidaInventario(@PathVariable Long id,
                                                                  @RequestBody SalidaInventario updatedSalidaInventario) {
        Optional<SalidaInventario> existingSalidaInventarioOptional = salidaInventarioRepository.findById(id);

        if (existingSalidaInventarioOptional.isPresent()) {
            SalidaInventario existingSalidaInventario = existingSalidaInventarioOptional.get();
            existingSalidaInventario.setIdIngrediente(updatedSalidaInventario.getIdIngrediente());
            existingSalidaInventario.setUnidadMedida(updatedSalidaInventario.getUnidadMedida());
            existingSalidaInventario.setCantidad(updatedSalidaInventario.getCantidad());
            existingSalidaInventario.setFechaSalida(updatedSalidaInventario.getFechaSalida());
            existingSalidaInventario.setIdUsuario(updatedSalidaInventario.getIdUsuario());

            SalidaInventario updatedSavedSalidaInventario = salidaInventarioRepository.save(existingSalidaInventario);
            return ResponseEntity.ok(updatedSavedSalidaInventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalidaInventario(@PathVariable Long id) {
        if (salidaInventarioRepository.existsById(id)) {
            salidaInventarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
