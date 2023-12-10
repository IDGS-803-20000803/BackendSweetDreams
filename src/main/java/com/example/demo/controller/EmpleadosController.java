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

import com.example.demo.model.Empleados;
import com.example.demo.model.Menu;
import com.example.demo.repository.EmpleadosRepository;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmpleadosController {
	
	@Autowired
	EmpleadosRepository empleadosRepository;
	
    @GetMapping
    public List<Empleados> getRecetas() {
     return empleadosRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Empleados> obtenerEmpleadoPorId(@PathVariable(value = "id") Integer id) {
        Optional<Empleados> empleado = empleadosRepository.findById(id);

        if (empleado.isPresent()) {
            return ResponseEntity.ok().body(empleado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Empleados> crearEmpleado(@RequestBody Empleados empleado) {
    	
    	Empleados empleados = empleadosRepository.save(empleado);
      
        return ResponseEntity.ok(empleados);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Empleados> actualizarEmpleado(@PathVariable(value = "id") Integer id,
                                                        @RequestBody Empleados empleadoDetails) {
        Optional<Empleados> optionalEmpleado = empleadosRepository.findById(id);

        if (optionalEmpleado.isPresent()) {
            Empleados empleado = optionalEmpleado.get();
            empleado.setNombres(empleadoDetails.getNombres());
            empleado.setApellidos(empleadoDetails.getApellidos());
            empleado.setCelular(empleadoDetails.getCelular());
            empleado.setCodigoPostal(empleadoDetails.getCodigoPostal());
            empleado.setCalle(empleadoDetails.getCalle());
            empleado.setColonia(empleadoDetails.getColonia());
            empleado.setEstatus(empleadoDetails.getEstatus());
            empleado.setIdUsuario(empleadoDetails.getIdUsuario());

            Empleados empleadoActualizado = empleadosRepository.save(empleado);
            return ResponseEntity.ok().body(empleadoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable(value = "id") Integer id) {
        Optional<Empleados> optionalEmpleado = empleadosRepository.findById(id);

        if (optionalEmpleado.isPresent()) {
            empleadosRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
