package com.tecnologiaefinancas.foodiesapi.service;

import com.tecnologiaefinancas.foodiesapi.io.FoodRequest;
import com.tecnologiaefinancas.foodiesapi.io.FoodResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FoodService {

    String uploadFile(MultipartFile file);

    FoodResponse addFood(FoodRequest request, MultipartFile file);
}
