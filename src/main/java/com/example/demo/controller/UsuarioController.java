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

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
    @GetMapping
    public List<Usuarios> getUsuarios() {
     return usuarioRepository.findAll();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable Integer id) {
        Optional<Usuarios> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   
    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario) {
        Usuarios nuevoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios usuarioActualizado) {
        Optional<Usuarios> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuarios usuario = usuarioOptional.get();
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setContrasena(usuarioActualizado.getContrasena());
            usuario.setActivo(usuarioActualizado.getActivo());
            usuario.setFechaCreacion(usuarioActualizado.getFechaCreacion());

            Usuarios usuarioActualizadoDB = usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuarioActualizadoDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        Optional<Usuarios> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
}
