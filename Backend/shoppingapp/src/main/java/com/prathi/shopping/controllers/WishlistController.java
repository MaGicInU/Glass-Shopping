package com.prathi.shopping.controllers;


import com.prathi.shopping.entities.WishlistItem;
import com.prathi.shopping.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/wishlist")
public class WishlistController {

 private final WishlistRepository wishlistRepository;

 @Autowired
 public WishlistController(WishlistRepository wishlistRepository) {
     this.wishlistRepository = wishlistRepository;
 }

 @GetMapping
 public ResponseEntity<List<WishlistItem>> getWishlistItems() {
     List<WishlistItem> wishlistItems = wishlistRepository.findAll();
     return ResponseEntity.ok(wishlistItems);
 }

 @PostMapping
 public ResponseEntity<WishlistItem> addItemToWishlist(@RequestBody WishlistItem wishlistItem) {
     WishlistItem savedItem = wishlistRepository.save(wishlistItem);
     return ResponseEntity.ok(savedItem);
 }

 @DeleteMapping("/{wishlistItemId}")
 public ResponseEntity<Void> removeItemFromWishlist(@PathVariable Long wishlistItemId) {
     wishlistRepository.deleteById(wishlistItemId);
     return ResponseEntity.noContent().build();
 }

 // Add other methods for updating wishlist items if needed

}
