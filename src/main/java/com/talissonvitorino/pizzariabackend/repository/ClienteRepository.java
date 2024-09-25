package com.talissonvitorino.pizzariabackend.repository;


import com.talissonvitorino.pizzariabackend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}