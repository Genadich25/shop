package com.cursetwo.shop.services;

import java.util.List;


public interface ShopService {
    public String addItem(String item);

    public List<String> getShoppingCart();
}
