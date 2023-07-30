package com.enterprisechallegenge.api.repositories;

import com.enterprisechallegenge.api.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


}
