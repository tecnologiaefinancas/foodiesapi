package com.tecnologiaefinancas.foodiesapi.config;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.exception.StripeException;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;


public class TestPayment {
    @Value("${stripe_secret}")
    public static String stripeSecretKey;
    public static void main(String[] args) {
        try {
            Stripe.apiKey = stripeSecretKey;
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(5000L) // R$50,00 em centavos
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
            System.out.println("PaymentIntent criado: " + intent.getId());
            System.out.println("Status: " + intent.getStatus());
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }
}