package com.project3.revtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project3.revtech.controller.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
