package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long>{

}
