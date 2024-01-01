package com.prathi.shopping.controllers;

//CartController.java
package com.prathi.shopping.controller;

import com.prathi.shopping.entities.CartItem;
import com.prathi.shopping.entities.User;
import com.prathi.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/cart")
public class CartController {

 private final UserRepository userRepository;

 @Autowired
 public CartController(UserRepository userRepository) {
     this.userRepository = userRepository;
 }

 @GetMapping
 public List<CartItem> getCartItems(@RequestParam Long userId) {
     User user = userRepository.findById(userId)
             .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
     return user.getCart();
 }

 @PostMapping
 public List<CartItem> addItemToCart(@RequestParam Long userId, @RequestBody CartItem cartItem) {
     User user = userRepository.findById(userId)
             .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
     
     List<CartItem> userCart = user.getCart();
     userCart.add(cartItem);
     
     user.setCart(userCart);
     userRepository.save(user);

     return userCart;
 }

 @DeleteMapping("/{productId}")
 public List<CartItem> removeItemFromCart(@RequestParam Long userId, @PathVariable Long productId) {
     User user = userRepository.findById(userId)
             .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
     
     List<CartItem> userCart = user.getCart();
     userCart.removeIf(cartItem -> cartItem.getProductId().equals(productId));
     
     user.setCart(userCart);
     userRepository.save(user);

     return userCart;
 }

 @PostMapping("/{productId}")
 public List<CartItem> updateCartItem(@RequestParam Long userId, @PathVariable Long productId, @RequestBody String actionType) {
     User user = userRepository.findById(userId)
             .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
     
     List<CartItem> userCart = user.getCart();
     
     userCart.forEach(cartItem -> {
         if (cartItem.getProductId().equals(productId)) {
             if ("increment".equals(actionType)) {
                 cartItem.setQuantity(cartItem.getQuantity() + 1);
             } else if ("decrement".equals(actionType)) {
                 cartItem.setQuantity(cartItem.getQuantity() - 1);
             }
         }
     });
     
     user.setCart(userCart);
     userRepository.save(user);

     return userCart;
 }
}

