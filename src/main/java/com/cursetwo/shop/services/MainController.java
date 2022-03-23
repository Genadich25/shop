package com.cursetwo.shop.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class MainController {
    final ShopServiceImpl shopServiceImpl;

    public MainController(ShopServiceImpl shopServiceImpl) {
        this.shopServiceImpl = shopServiceImpl;
    }

    @GetMapping(path = "/")
    public Map<Integer, String> hello(){
        return shopServiceImpl.getAllItems();
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam String items){
        return shopServiceImpl.addItem(items);
    }

    @GetMapping(path = "/get")
    public List<String> get(){
        return shopServiceImpl.getShoppingCart();
    }

}
