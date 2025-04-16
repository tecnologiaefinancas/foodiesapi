package com.tecnologiaefinancas.foodiesapi.entity;

import com.tecnologiaefinancas.foodiesapi.io.OrderItem;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@Data
@Builder
public class OrderEntity {
    @Id
    private String id;
    private String userId;
    private String userAddress;
    private String phoneNumber;
    private String email;
    private List<OrderItem> orderedItems;
    private Long amount;
    private String paymentStatus;
    private String stripeOrderId;
    private String stripeSignature;
    private String orderStatus;
}
