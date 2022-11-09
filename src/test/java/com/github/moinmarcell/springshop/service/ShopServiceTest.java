package com.github.moinmarcell.springshop.service;

import com.github.moinmarcell.springshop.model.Order;
import com.github.moinmarcell.springshop.model.Product;
import com.github.moinmarcell.springshop.repository.OrderRepository;
import com.github.moinmarcell.springshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopServiceTest {
    OrderRepository orderRepository = mock(OrderRepository.class);
    ProductRepository productRepository = mock(ProductRepository.class);

    ShopService shopService = new ShopService(orderRepository, productRepository);

    @Test
    void getProduct() {
        //GIVEN
        String productId = "1";
        Product expectedProduct = new Product();

        //WHEN
        when(productRepository.get(productId)).thenReturn(expectedProduct);
        Product result = shopService.getProduct(productId);

        //THEN
        assertEquals(expectedProduct, result);
        verify(productRepository).get(any());
    }

    @Test
    void listProducts() {
        //GIVEN
        List<Product> expectedList = new ArrayList<>();

        //WHEN
        when(productRepository.list()).thenReturn(expectedList);
        List<Product> result = shopService.listProducts();

        //THEN
        assertEquals(expectedList, result);
        verify(productRepository).list();
    }

    @Test
    void listOrders() {
        //GIVEN
        List<Order> expectedOrders = new ArrayList<>();

        //WHEN
        when(orderRepository.list()).thenReturn(expectedOrders);
        List<Order> result = shopService.listOrders();

        //THEN
        assertEquals(expectedOrders, result);
        verify(orderRepository).list();
    }

    @Test
    void getOrder() {
        //GIVEN
        String orderId = "1";
        Order expectedOrder = new Order();

        //WHEN
        when(orderRepository.get(orderId)).thenReturn(expectedOrder);
        Order result = shopService.getOrder(orderId);

        //THEN
        assertEquals(expectedOrder, result);
        verify(orderRepository).get(any());
    }

    @Test
    void addOrder() {
        //GIVEN
        String id = "1";
        List<String> ids = new ArrayList<>();
        Order expectedOrder = new Order(id, Collections.emptyList());

        //WHEN
        when(orderRepository.add(expectedOrder)).thenReturn(expectedOrder);
        Order result = shopService.addOrder(id, ids);

        //THEN
        //verify(orderRepository).add(expectedOrder);
        assertEquals(expectedOrder, result);
        verify(orderRepository).add(expectedOrder);
    }
}