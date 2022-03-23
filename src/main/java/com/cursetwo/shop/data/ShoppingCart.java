package com.cursetwo.shop.data;

import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
public class ShoppingCart {
    private final List<String> shoppingCart;

    public ShoppingCart() {
        this.shoppingCart = new ArrayList<>();
    }

    public List<String> getShoppingCart() {
        return shoppingCart;
    }

    public void add(String item){
        shoppingCart.add(item);
    }
}
