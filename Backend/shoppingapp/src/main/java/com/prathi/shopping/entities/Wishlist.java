package com.prathi.shopping.entities;


import javax.persistence.*;

@Entity
public class WishlistItem {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private Long productId;

 // Add other fields as needed

 // Constructors, getters, and setters

 public WishlistItem() {
 }

 public WishlistItem(Long productId) {
     this.productId = productId;
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

 // Add other getters and setters for additional fields

 @Override
 public String toString() {
     return "WishlistItem{" +
             "id=" + id +
             ", productId=" + productId +
             // Add other fields to toString() if needed
             '}';
 }
}
