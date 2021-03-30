package com.example.AutoWorkShop.service;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.service.CarAddServiceModel;
import com.example.AutoWorkShop.view.CarViewModel;
import com.example.AutoWorkShop.view.CarViewModelWithRepairs;

import java.util.List;

public interface CarService {
    List<CarViewModel> findCarByRegNumber(String number);

    List<CarViewModel> findCarByVin(String vin);

    Long inputCar(CarAddServiceModel carAddServiceModel, String username);

    boolean carExist(String vin);

    List<CarViewModel> findCarByBrand(String brand);

    List<CarViewModel> findCarByBrandAndModel(String brand, String model);

    List<CarViewModel> findAllByEngine(String engine);

    List<CarViewModel> findCarByCoupeModel(String coupeModel);

    List<CarViewModel> findAllCars();

    String findCarByRegistrationNumber(String car);

    CarViewModel findCarById(Long id);

    CarViewModelWithRepairs findCarWithRepairsById(Long id);

    CarEntity findCarEntityById(Long id);

    void updateClient(CarAddServiceModel updatedCar);
}
