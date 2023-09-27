package com.enterprisechallegenge.api.repositories;

import com.enterprisechallegenge.api.entities.Patient;
import com.enterprisechallegenge.api.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Long> {


}
