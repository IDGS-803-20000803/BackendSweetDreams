package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {

}
