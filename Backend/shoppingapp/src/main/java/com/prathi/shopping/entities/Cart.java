package com.prathi.shopping.entities;

import javax.persistence.*;

@Entity
public class Cart{

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private Long productId;

 @Column(nullable = false)
 private int quantity;

 // Add other fields as needed

 // Constructors, getters, and setters

 public CartItem() {
 }

 public CartItem(Long productId, int quantity) {
     this.productId = productId;
     this.quantity = quantity;
 }

 // Getters and setters

 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public Long getProductId() {
     return productId;
 }

 public void setProductId(Long productId) {
     this.productId = productId;
 }

 public int getQuantity() {
     return quantity;
 }

 public void setQuantity(int quantity) {
     this.quantity = quantity;
 }

 // Add other getters and setters for additional fields

 @Override
 public String toString() {
     return "CartItem{" +
             "id=" + id +
             ", productId=" + productId +
             ", quantity=" + quantity +
             // Add other fields to toString() if needed
             '}';
 }
}

