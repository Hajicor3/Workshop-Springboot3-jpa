package com.hajicor3.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hajicor3.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
