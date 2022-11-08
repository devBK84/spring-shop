package com.github.moinmarcell.springshop.controller;

import com.github.moinmarcell.springshop.model.Order;
import com.github.moinmarcell.springshop.model.Product;
import com.github.moinmarcell.springshop.repository.OrderRepository;
import com.github.moinmarcell.springshop.repository.ProductRepository;
import com.github.moinmarcell.springshop.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return shopService.listProducts();
    }

    @GetMapping(path = "/products/{id}")
    public Product getProduct(@PathVariable String id){
        return shopService.getProduct(id);
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return shopService.listOrders();
    }

    @GetMapping(path = "/orders/{id}")
    public Order getOrder(@PathVariable String id){
        return shopService.getOrder(id);
    }

    @PostMapping("/orders/addorder")
    public Order addOrder(@RequestBody String orderId, @RequestBody List<String> ids){
        return shopService.addOrder(orderId, ids);
    }

}
