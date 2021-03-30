package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.entities.OrderEntity;
import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.entities.enums.ProgressEnum;
import com.example.AutoWorkShop.domain.service.OrderAddServiceModel;
import com.example.AutoWorkShop.repository.CarRepository;
import com.example.AutoWorkShop.repository.OrderRepository;
import com.example.AutoWorkShop.repository.UserRepository;
import com.example.AutoWorkShop.service.OrderService;
import com.example.AutoWorkShop.view.OrderViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;


    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, CarRepository carRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderEntity> findOrderByCarBrand(String carBrand) {
        return this.orderRepository.findOrderByCarBrand(carBrand);
    }

    @Override
    public List<OrderEntity> findOrderByCarVin(String carVin) {
        return this.orderRepository.findOrderByCarVin(carVin);
    }

    @Override
    public List<OrderEntity> findOrderByCarRegNumber(String carRegNumber) {
        return this.orderRepository.findOrderByCarRegNumber(carRegNumber);
    }

    @Override
    public void inputOrder(OrderAddServiceModel orderAddServiceModel) {
        OrderEntity orderEntity = modelMapper.map(orderAddServiceModel, OrderEntity.class);
        LocalDate now = LocalDate.now();
        UserEntity username = userRepository.
                findByUsername(orderAddServiceModel.getUserEntity()).
                orElseThrow(() -> new IllegalArgumentException("Creator " + orderAddServiceModel.getUserEntity() + " could not be found"));

        CarEntity carEntity = carRepository.findById(orderAddServiceModel.getCar().getId()).orElse(null);
        if (carEntity != null) {
            orderEntity.setUserEntity(username);
            orderEntity.setCar(carEntity);
            orderEntity.setDataOrder(now)
                    .setClassificationEnum(orderAddServiceModel.getClassificationEnum())
                    .setProgressEnum(orderAddServiceModel.getProgressEnum())
                    .setComment(orderAddServiceModel.getComment())
                    .setDataIn(orderAddServiceModel.getDataIn());
            orderRepository.save(orderEntity);
        }

    }

    @Override
    public List<OrderViewModel> findAllOrdersView() {
        return orderRepository
                .findAll()
                .stream()
                .map(ord -> modelMapper.map(ord, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderViewModel findById(Long id) {
        return orderRepository.findById(id)
                .map(ord -> modelMapper.map(ord, OrderViewModel.class))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    @Transactional
    public List<OrderViewModel> findAllOrdersByUsername(String username) {
        return orderRepository
                .findAllByUserEntity_Username(username)
                .stream()
                .map(ordUser -> modelMapper.map(ordUser, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateById(Long id) {
        OrderEntity orderEntity = this.orderRepository.getOne(id);
        String name = orderEntity.getProgressEnum().name();
        switch (name) {
            case "OPEN":
                orderEntity.setProgressEnum(ProgressEnum.IN_PROGRESS);
                break;
            case "IN_PROGRESS":
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDate now = LocalDate.now();
                orderEntity.setProgressEnum(ProgressEnum.COMPLETED)
                        .setDataOut((now));
                break;
            case "COMPLETED":
                orderRepository.delete(orderEntity);
                break;
        }
    }
}
