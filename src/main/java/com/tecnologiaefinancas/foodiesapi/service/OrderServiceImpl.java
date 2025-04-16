package com.tecnologiaefinancas.foodiesapi.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.tecnologiaefinancas.foodiesapi.entity.OrderEntity;
import com.tecnologiaefinancas.foodiesapi.io.OrderRequest;
import com.tecnologiaefinancas.foodiesapi.io.OrderResponse;
import com.tecnologiaefinancas.foodiesapi.repository.OrderRepository;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{


    private final OrderRepository orderRepository;


    private final UserService userService;

    @Value("${stripe_public_key}")
    private String STRIPE_PUBLIC_KEY;
    @Value("${stripe_secret}")
    private String STRIPE_SECRET;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    @Override
    public OrderResponse createOrderWithPayment(OrderRequest request) {
        OrderEntity newOrder = convertToEntity(request);
        String loggedInUserId = userService.findByUserId();
        newOrder.setUserId(loggedInUserId);
        newOrder = orderRepository.save(newOrder);

        //create stripe payment order
        try {
            Stripe.apiKey = STRIPE_SECRET;
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(newOrder.getAmount())
                    .setCurrency("brl")
                    .addPaymentMethodType("card") // Define o tipo de pagamento
                    .setPaymentMethodOptions(
                            PaymentIntentCreateParams.PaymentMethodOptions.builder()
                                    .setCard(
                                            PaymentIntentCreateParams.PaymentMethodOptions.Card.builder()
                                                    .setRequestThreeDSecure(
                                                            PaymentIntentCreateParams.PaymentMethodOptions.Card.RequestThreeDSecure.AUTOMATIC
                                                    ) // Define 'automatic' ou 'required'
                                                    .build()
                                    ).build()
                    )
                    .build();

            PaymentIntent intent = PaymentIntent.create(params);
            newOrder.setStripeOrderId(intent.getId());
            newOrder = orderRepository.save(newOrder);
            System.out.println("PaymentIntent criado: " + intent.getId());
            System.out.println("Status: " + intent.getStatus());
        } catch (StripeException e) {
            e.printStackTrace();
        }
     return convertToResponse(newOrder);
    }

    private OrderResponse convertToResponse(OrderEntity newOrder) {
        return OrderResponse.builder()
                .id(newOrder.getId())
                .amount(newOrder.getAmount())
                .userAddress(newOrder.getUserAddress())
                .userId(newOrder.getUserId())
                .stripeOrderId(newOrder.getStripeOrderId())
                .paymentStatus(newOrder.getPaymentStatus())
                .orderStatus(newOrder.getOrderStatus())
                .email(newOrder.getEmail())
                .phoneNumber(newOrder.getPhoneNumber())
                .build();
    }

    private OrderEntity convertToEntity(OrderRequest request) {
        return OrderEntity.builder()
                .userAddress(request.getUserAddress())
                .amount(request.getAmount())
                .orderedItems(request.getOrderedItems())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .orderStatus(request.getOrderStatus())
                .build();
    }
}
