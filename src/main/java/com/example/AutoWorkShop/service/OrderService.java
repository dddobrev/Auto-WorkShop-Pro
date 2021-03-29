package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.OrderEntity;
import com.example.AutoWorkShop.domain.service.OrderAddServiceModel;
import com.example.AutoWorkShop.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    List<OrderEntity> findOrderByCarBrand(String carBrand);

    List<OrderEntity> findOrderByCarVin(String carVin);

    List<OrderEntity> findOrderByCarRegNumber(String carRegNumber);

    void inputOrder(OrderAddServiceModel orderAddServiceModel);

    List<OrderViewModel> findAllOrdersView();

    OrderViewModel findById(Long id);

    List<OrderViewModel> findAllOrdersByUsername(String username);

    void updateById(Long id);
}
