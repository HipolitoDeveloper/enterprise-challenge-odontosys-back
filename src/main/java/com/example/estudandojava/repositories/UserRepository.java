package com.example.estudandojava.repositories;

import com.example.estudandojava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
