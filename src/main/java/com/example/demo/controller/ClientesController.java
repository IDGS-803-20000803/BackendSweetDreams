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
import com.example.demo.model.Clientes;
import com.example.demo.repository.ClientesRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientesController {
	
	@Autowired
	ClientesRepository clientesRepository;
	
	
    @GetMapping
    public List<Clientes> getRecetas() {
     return clientesRepository.findAll();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getClienteById(@PathVariable Integer id) {
        Optional<Clientes> clienteOptional = clientesRepository.findById(id);
        if (clienteOptional.isPresent()) {
            return ResponseEntity.ok(clienteOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Clientes> crearCliente(@RequestBody Clientes cliente) {
        Clientes nuevoCliente = clientesRepository.save(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Clientes> actualizarCliente(@PathVariable Integer id, @RequestBody Clientes clienteActualizado) {
        Optional<Clientes> clienteOptional = clientesRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Clientes cliente = clienteOptional.get();
            cliente.setNombres(clienteActualizado.getNombres());
            cliente.setApellidos(clienteActualizado.getApellidos());
            cliente.setCelular(clienteActualizado.getCelular());
            cliente.setCodigoPostal(clienteActualizado.getCodigoPostal());
            cliente.setCalle(clienteActualizado.getCalle());
            cliente.setColonia(clienteActualizado.getColonia());
            cliente.setEstatus(clienteActualizado.getEstatus());
            cliente.setIdUsuario(clienteActualizado.getIdUsuario());

            Clientes clienteActualizadoDB = clientesRepository.save(cliente);
            return ResponseEntity.ok(clienteActualizadoDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id) {
        Optional<Clientes> clienteOptional = clientesRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clientesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
