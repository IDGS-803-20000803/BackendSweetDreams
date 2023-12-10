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

import com.example.demo.model.Ingrediente;
import com.example.demo.repository.IngredienteRepository;

@RestController
@RequestMapping("/ingredientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IngredienteController {
	
	  @Autowired
	    private IngredienteRepository ingredienteService;

	
	    @GetMapping
	    public List<Ingrediente> obtenerTodosIngredientes() {
	        return ingredienteService.findAll();
	    }
	    
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Ingrediente> obtenerIngredientePorId(@PathVariable Integer id) {
	        Optional<Ingrediente> ingredienteOptional = ingredienteService.findById(id);
	        if (ingredienteOptional.isPresent()) {
	            return ResponseEntity.ok(ingredienteOptional.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	  
	    @PostMapping
	    public ResponseEntity<Ingrediente> crearIngrediente(@RequestBody Ingrediente ingrediente) {
	        Ingrediente nuevoIngrediente = ingredienteService.save(ingrediente);
	        return ResponseEntity.ok(nuevoIngrediente);
	    }


	    @PutMapping("/{id}")
	    public ResponseEntity<Ingrediente> actualizarIngrediente(@PathVariable Integer id, @RequestBody Ingrediente ingredienteActualizado) {
	        Optional<Ingrediente> ingredienteOptional = ingredienteService.findById(id);
	        if (ingredienteOptional.isPresent()) {
	            Ingrediente ingrediente = ingredienteOptional.get();
	            ingrediente.setNombre(ingredienteActualizado.getNombre());
	            ingrediente.setUnidadMedida(ingredienteActualizado.getUnidadMedida());
	            ingrediente.setCantidadMedida(ingredienteActualizado.getCantidadMedida());
	            ingrediente.setEstatus(ingredienteActualizado.getEstatus());

	            Ingrediente ingredienteActualizadoDB = ingredienteService.save(ingrediente);
	            return ResponseEntity.ok(ingredienteActualizadoDB);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminarIngrediente(@PathVariable Integer id) {
	        Optional<Ingrediente> ingredienteOptional = ingredienteService.findById(id);
	        if (ingredienteOptional.isPresent()) {
	            ingredienteService.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }



}
