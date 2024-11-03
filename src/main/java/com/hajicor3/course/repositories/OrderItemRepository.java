package com.hajicor3.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hajicor3.course.entities.OrderItem;
import com.hajicor3.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
