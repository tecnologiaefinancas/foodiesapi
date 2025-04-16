package com.tecnologiaefinancas.foodiesapi.config;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {
    @Value("${stripe_secret}")
    public static String stripeSecretKey;
    public static void main(String[] args) {

        Stripe.apiKey = stripeSecretKey;
    }
}
