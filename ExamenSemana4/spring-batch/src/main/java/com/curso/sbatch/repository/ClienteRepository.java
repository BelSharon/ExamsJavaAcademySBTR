package com.curso.sbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.sbatch.entity.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente,Integer> {
}
