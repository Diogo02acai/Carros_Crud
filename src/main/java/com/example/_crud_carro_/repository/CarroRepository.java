package com.example._crud_carro_.repository;

import com.example._crud_carro_.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {}
