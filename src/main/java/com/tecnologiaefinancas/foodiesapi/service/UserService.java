package com.tecnologiaefinancas.foodiesapi.service;

import com.tecnologiaefinancas.foodiesapi.io.UserRequest;
import com.tecnologiaefinancas.foodiesapi.io.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);

    String findByUserId();
}
