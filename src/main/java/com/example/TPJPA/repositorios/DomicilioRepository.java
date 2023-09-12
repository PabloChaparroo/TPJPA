package com.example.TPJPA.repositorios;

import com.example.TPJPA.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository <Domicilio, Long> {
}
