package com.hajicor3.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hajicor3.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
