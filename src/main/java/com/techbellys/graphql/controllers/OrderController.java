package com.techbellys.graphql.controllers;

import com.techbellys.graphql.entities.Order;
import com.techbellys.graphql.entities.User;
import com.techbellys.graphql.services.OrderService;
import com.techbellys.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }
    @MutationMapping(name = "createOrder")
    public Order createOrder(@Argument String orderDetail, @Argument String address, @Argument int price, @Argument int userId){
        User user = userService.getUser(userId);
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        return orderService.createOrder(order);
    }
    @QueryMapping(name = "getOrders")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }
    @QueryMapping(name = "getOrder")
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }
    @MutationMapping(name = "deleteOrder")
    public boolean deleteOrder(@Argument int orderId) {
        return orderService.deleteOrder(orderId);

    }

}
