package com.cursetwo.shop.services;

import com.cursetwo.shop.data.ShoppingCart;
import com.cursetwo.shop.exceptions.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SessionScope
public class ShopServiceImpl implements ShopService{

    private final ShoppingCart shoppingCart = new ShoppingCart();

    private final Map<Integer, String> allItems = new HashMap<>(Map.of(
            1, "Хлеб",
            2, "Молоко",
            3, "Футболка",
            4, "Яблоко",
            5, "Банан",
            6, "Лимонад",
            7, "Туфли"));



    public String addItem(String items){
        String[] itemsArray = StringUtils.splitByWholeSeparator(items,"-", 0);
        int count = 0;
        for (int i = 0; i < itemsArray.length; i++) {
            if(StringUtils.isNumeric(itemsArray[i])){
                Integer integerItem = Integer.parseInt(itemsArray[i]);
                if (allItems.containsKey(integerItem)){
                    shoppingCart.add(allItems.get(integerItem));
                    count++;
                }
            }
        }
        if(count <= 0){
            throw new NotFoundException();
        }
        return count + " товаров добавлено в корзину!";
    }

    public List<String> getShoppingCart(){
        return shoppingCart.getShoppingCart();
    }

    public Map<Integer, String> getAllItems() {
        return allItems;
    }
}
