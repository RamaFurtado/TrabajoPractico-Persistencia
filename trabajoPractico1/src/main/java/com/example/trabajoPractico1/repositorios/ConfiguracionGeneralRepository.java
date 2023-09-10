package com.example.trabajoPractico1.repositorios;

import com.example.trabajoPractico1.entidades.ConfiguracionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionGeneralRepository extends JpaRepository<ConfiguracionGeneral,Long> {
}
