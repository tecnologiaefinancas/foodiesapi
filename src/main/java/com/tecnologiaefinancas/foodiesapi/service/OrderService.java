package com.tecnologiaefinancas.foodiesapi.service;

import com.tecnologiaefinancas.foodiesapi.io.OrderRequest;
import com.tecnologiaefinancas.foodiesapi.io.OrderResponse;

public interface OrderService {

    OrderResponse createOrderWithPayment(OrderRequest request);
}
