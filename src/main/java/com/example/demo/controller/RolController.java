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

import com.example.demo.model.Menu;
import com.example.demo.model.Rol;
import com.example.demo.repository.RolRepository;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RolController {
	
	@Autowired
	RolRepository rolRepository;
	
    @GetMapping
    public List<Rol> getRecetas() {
     return rolRepository.findAll();
    }
    
    

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Integer id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        if (rolOptional.isPresent()) {
            return ResponseEntity.ok(rolOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolRepository.save(rol);
        return ResponseEntity.ok(nuevoRol);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol rolActualizado) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        if (rolOptional.isPresent()) {
            Rol rol = rolOptional.get();
            rol.setNombre(rolActualizado.getNombre());
            rol.setDescripcion(rolActualizado.getDescripcion());

            Rol rolActualizadoDB = rolRepository.save(rol);
            return ResponseEntity.ok(rolActualizadoDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Integer id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        if (rolOptional.isPresent()) {
            rolRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    

}
