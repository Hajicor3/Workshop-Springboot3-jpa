package com.hajicor3.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hajicor3.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
