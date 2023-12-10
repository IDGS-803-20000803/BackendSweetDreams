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
import com.example.demo.model.Receta;
import com.example.demo.repository.MenuRepository;

@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {

	@Autowired
	MenuRepository menuRepository;
	
    @GetMapping
    public List<Menu> getRecetas() {
     return menuRepository.findAll();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Integer id) {
    	
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isPresent()) {
            return ResponseEntity.ok(menuOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Menu> crearMenu(@RequestBody Menu menu) {
        Menu nuevoMenu = menuRepository.save(menu);
        return ResponseEntity.ok(nuevoMenu);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Menu> actualizarMenu(@PathVariable Integer id, @RequestBody Menu menuActualizado) {
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isPresent()) {
            Menu menu = menuOptional.get();
            menu.setIdReceta(menuActualizado.getIdReceta());
            menu.setFoto(menuActualizado.getFoto());
            menu.setCosto(menuActualizado.getCosto());
            menu.setEstatus(menuActualizado.getEstatus());

            Menu menuActualizadoDB = menuRepository.save(menu);
            return ResponseEntity.ok(menuActualizadoDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMenu(@PathVariable Integer id) {
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if (menuOptional.isPresent()) {
            menuRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
	
	
 
}
