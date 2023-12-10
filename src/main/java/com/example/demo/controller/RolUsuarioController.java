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

import com.example.demo.model.RolUsuario;
import com.example.demo.repository.RolUsuarioRepository;

@RestController
@RequestMapping("/rolesusuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RolUsuarioController {
    
	@Autowired
	RolUsuarioRepository roleUsuarioRepository;
	
	
    @GetMapping
    public List<RolUsuario> getRecetas() {
     return roleUsuarioRepository.findAll();
    }
    
    
    
    @GetMapping("/{id}")
    public ResponseEntity<RolUsuario> getRolUsuarioById(@PathVariable Integer id) {
        Optional<RolUsuario> rolUsuarioOptional = roleUsuarioRepository.findById(id);
        if (rolUsuarioOptional.isPresent()) {
            return ResponseEntity.ok(rolUsuarioOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<RolUsuario> crearRolUsuario(@RequestBody RolUsuario rolUsuario) {
        RolUsuario nuevoRolUsuario = roleUsuarioRepository.save(rolUsuario);
        return ResponseEntity.ok(nuevoRolUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolUsuario> actualizarRolUsuario(@PathVariable Integer id, @RequestBody RolUsuario rolUsuarioActualizado) {
        Optional<RolUsuario> rolUsuarioOptional = roleUsuarioRepository.findById(id);
        if (rolUsuarioOptional.isPresent()) {
            RolUsuario rolUsuario = rolUsuarioOptional.get();
            rolUsuario.setIdUsuario(rolUsuarioActualizado.getIdUsuario());
            rolUsuario.setIdRol(rolUsuarioActualizado.getIdRol());

            RolUsuario rolUsuarioActualizadoDB = roleUsuarioRepository.save(rolUsuario);
            return ResponseEntity.ok(rolUsuarioActualizadoDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRolUsuario(@PathVariable Integer id) {
        Optional<RolUsuario> rolUsuarioOptional = roleUsuarioRepository.findById(id);
        if (rolUsuarioOptional.isPresent()) {
            roleUsuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
