package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.model.Receta;
import com.example.demo.repository.RecetaRepository;

@RestController
@RequestMapping("/recetas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecetaController {
	
	@Autowired
	RecetaRepository recetaRepository;
	
    @GetMapping
    public List<Receta> getRecetas() {
        return recetaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Receta> getRecetaById(@PathVariable Integer id) {
        Optional<Receta> recetaOptional = recetaRepository.findById(id);
        if (recetaOptional.isPresent()) {
            return ResponseEntity.ok(recetaOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Receta> crearReceta(@RequestBody Receta receta) {
        Receta nuevaReceta = recetaRepository.save(receta);
        return ResponseEntity.ok(nuevaReceta);
    }

 
    @PutMapping("/{id}")
    public ResponseEntity<Receta> actualizarReceta(@PathVariable Integer id, @RequestBody Receta recetaActualizada) {
        Optional<Receta> recetaOptional = recetaRepository.findById(id);
        if (recetaOptional.isPresent()) {
            Receta receta = recetaOptional.get();
            receta.setNombreReceta(recetaActualizada.getNombreReceta());
            receta.setTiempoDuracion(recetaActualizada.getTiempoDuracion());
            receta.setEstatus(recetaActualizada.getEstatus());

            Receta recetaActualizadaDB = recetaRepository.save(receta);
            return ResponseEntity.ok(recetaActualizadaDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReceta(@PathVariable Integer id) {
        Optional<Receta> recetaOptional = recetaRepository.findById(id);
        if (recetaOptional.isPresent()) {
            recetaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
