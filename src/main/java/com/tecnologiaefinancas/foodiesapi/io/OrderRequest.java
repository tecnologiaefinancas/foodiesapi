package com.tecnologiaefinancas.foodiesapi.io;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderRequest {
    private List<OrderItem> orderedItems;
    private String userAddress;
    private Long amount;
    private String email;
    private String phoneNumber;
    private String orderStatus;
}
