package com.provincia.clima.repository;

import com.provincia.clima.entities.ClimaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimaRepository extends JpaRepository<ClimaEntity, Long> {

}
