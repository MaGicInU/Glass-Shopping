package com.prathi.shopping.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Category {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String categoryName;

 @Column(columnDefinition = "TEXT", nullable = false)
 private String description;

 @Column(nullable = false)
 private String categoryImg;

 // getters and setters

 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public String getCategoryName() {
     return categoryName;
 }

 public void setCategoryName(String categoryName) {
     this.categoryName = categoryName;
 }

 public String getDescription() {
     return description;
 }

 public void setDescription(String description) {
     this.description = description;
 }

 public String getCategoryImg() {
     return categoryImg;
 }

 public void setCategoryImg(String categoryImg) {
     this.categoryImg = categoryImg;
 }
}
