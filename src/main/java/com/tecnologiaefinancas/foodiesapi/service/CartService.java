package com.tecnologiaefinancas.foodiesapi.service;

import com.tecnologiaefinancas.foodiesapi.io.CartRequest;
import com.tecnologiaefinancas.foodiesapi.io.CartResponse;

public interface CartService {

    CartResponse addToCart(CartRequest request);
}
