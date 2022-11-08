package com.github.moinmarcell.springshop.repository;

import com.github.moinmarcell.springshop.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class OrderRepository {

    private List<Order> orders;
    public OrderRepository(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> list() {
        return orders;
    }

    public Order get(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public Order add(Order orderToAdd) {
        orders.add(orderToAdd);
        return orderToAdd;
    }
}