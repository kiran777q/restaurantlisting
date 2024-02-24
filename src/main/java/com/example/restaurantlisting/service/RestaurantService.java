package com.example.restaurantlisting.service;

import com.example.restaurantlisting.dto.RestaurantDTO;
import com.example.restaurantlisting.entity.Restaurant;
import com.example.restaurantlisting.mapper.RestaurantMapper;
import com.example.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        //map it to list of DTOs
        List<RestaurantDTO> restaurantsDTOList = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return restaurantsDTOList;
    }
}
