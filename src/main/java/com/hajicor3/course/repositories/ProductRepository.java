package com.hajicor3.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hajicor3.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
