package com.prathi.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prathi.shopping.entities.Products;

import jakarta.transaction.Transactional;

public interface ShoppingRepo extends JpaRepository<Products,Integer>{
}
