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

import com.example.demo.model.Detallereceta;
import com.example.demo.repository.DetalleRecetaRepository;

@RestController
@RequestMapping("/detalleRecetas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DetalleRecetaController {
	
	@Autowired
	DetalleRecetaRepository detalleRecetasRepo;
	
    @GetMapping
    public List<Detallereceta> getDetalleRecetas() {
     return detalleRecetasRepo.findAll();
    }
    
   
    @GetMapping("/{id}")
    public ResponseEntity<Detallereceta> getDetalleRecetaById(@PathVariable Integer id) {
        Optional<Detallereceta> detalleRecetaOptional = detalleRecetasRepo.findById(id);
        if (detalleRecetaOptional.isPresent()) {
            return ResponseEntity.ok(detalleRecetaOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  
    @PostMapping
    public ResponseEntity<Detallereceta> crearDetalleReceta(@RequestBody Detallereceta detalleReceta) {
        Detallereceta nuevoDetalleReceta = detalleRecetasRepo.save(detalleReceta);
        return ResponseEntity.ok(nuevoDetalleReceta);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Detallereceta> actualizarDetalleReceta(@PathVariable Integer id, @RequestBody Detallereceta detalleRecetaActualizado) {
        Optional<Detallereceta> detalleRecetaOptional = detalleRecetasRepo.findById(id);
        if (detalleRecetaOptional.isPresent()) {
            Detallereceta detalleReceta = detalleRecetaOptional.get();
            detalleReceta.setIdReceta(detalleRecetaActualizado.getIdReceta());
            detalleReceta.setIdIngrediente(detalleRecetaActualizado.getIdIngrediente());
            detalleReceta.setCantidad(detalleRecetaActualizado.getCantidad());
            detalleReceta.setDescripcion(detalleRecetaActualizado.getDescripcion());
            detalleReceta.setEstatus(detalleRecetaActualizado.getEstatus());

            Detallereceta detalleRecetaActualizadoDB = detalleRecetasRepo.save(detalleReceta);
            return ResponseEntity.ok(detalleRecetaActualizadoDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleReceta(@PathVariable Integer id) {
        Optional<Detallereceta> detalleRecetaOptional = detalleRecetasRepo.findById(id);
        if (detalleRecetaOptional.isPresent()) {
            detalleRecetasRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
