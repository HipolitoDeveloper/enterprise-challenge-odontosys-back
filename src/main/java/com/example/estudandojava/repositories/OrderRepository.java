package com.example.estudandojava.repositories;

import com.example.estudandojava.entities.Order;
import com.example.estudandojava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
