package com.tecnologiaefinancas.foodiesapi.service;

import com.tecnologiaefinancas.foodiesapi.io.OrderRequest;
import com.tecnologiaefinancas.foodiesapi.io.OrderResponse;

import java.util.Map;
import java.util.List;

public interface OrderService {

    OrderResponse createOrderWithPayment(OrderRequest request);

    void verifyPayment(Map<String, String> paymentData, String status);

    List<OrderResponse> getUserOrders();

    void removeOrder(String orderId);

    List<OrderResponse> getOrdersOfAllUsers();

    void updateOrderStatus(String orderId, String status);
}
