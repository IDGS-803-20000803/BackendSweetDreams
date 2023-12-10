package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EntradaInventario;

public interface EntradaInventarioRepository extends JpaRepository<EntradaInventario, Long> {

}
