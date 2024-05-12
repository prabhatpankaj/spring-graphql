package com.techbellys.graphql.services;

import com.techbellys.graphql.entities.Order;
import com.techbellys.graphql.helper.ExceptionHelper;
import com.techbellys.graphql.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrder(int orderId) {
        return orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResoureNotFoundException);
    }

    public boolean deleteOrder(int orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResoureNotFoundException);
        orderRepo.delete(order);
        return true;
    }
}
