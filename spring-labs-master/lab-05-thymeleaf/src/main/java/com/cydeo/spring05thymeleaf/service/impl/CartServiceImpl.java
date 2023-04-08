package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){

        //todo retrieve product from repository method  DONE
        Product product = productService.findProductById(productId);

        //todo initialise cart item
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        //todo add to cart
        //I need to add product and quantity to carItem

        //set cartItem totalAmount

        //totalAmount = productPrice * Quantity
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity) ));


        //todo calculate cart total amount
        //add cartItem to cart
        CART.getCartItemList().add(cartItem);

        //update CART totalAmount
        CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //todo delete product object from cart using stream
        //I need to find CartItem to delete based on product ID
        CartItem itemToDelete = CART.getCartItemList().stream()
                .filter(c -> c.getProduct().getId().equals(productId))
                .findAny().orElseThrow();

        //total cart amount needs to be updated with subtracting the itemTolDelete amount
        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(itemToDelete.getTotalAmount()));

        //remove itemToDelete from the list<cartItem>

        return CART.getCartItemList().remove(itemToDelete);
    }
}
