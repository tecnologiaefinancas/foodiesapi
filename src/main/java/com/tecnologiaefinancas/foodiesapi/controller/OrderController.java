package com.tecnologiaefinancas.foodiesapi.controller;

import com.tecnologiaefinancas.foodiesapi.io.OrderRequest;
import com.tecnologiaefinancas.foodiesapi.io.OrderResponse;
import com.tecnologiaefinancas.foodiesapi.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public OrderResponse creatOrderWithPayment(@RequestBody OrderRequest request){
        OrderResponse response = orderService.createOrderWithPayment(request);
        return response;
    }
}
