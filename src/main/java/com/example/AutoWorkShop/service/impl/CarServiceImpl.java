package com.example.AutoWorkShop.service.impl;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.domain.entities.RepairEntity;
import com.example.AutoWorkShop.domain.entities.UserEntity;
import com.example.AutoWorkShop.domain.service.CarAddServiceModel;
import com.example.AutoWorkShop.domain.util.FileUtil;
import com.example.AutoWorkShop.repository.CarRepository;
import com.example.AutoWorkShop.repository.UserRepository;
import com.example.AutoWorkShop.service.CarService;
import com.example.AutoWorkShop.view.CarViewModel;
import com.example.AutoWorkShop.view.CarViewModelWithRepairs;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public CarServiceImpl(CarRepository repository,
                          FileUtil fileUtil,
                          ModelMapper modelMapper, UserRepository userRepository) {
        this.carRepository = repository;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @Override
    public Long inputCar(CarAddServiceModel carAddServiceModel, String username) {
        CarEntity newCar = modelMapper.map(carAddServiceModel, CarEntity.class);
        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
        setCar(carAddServiceModel, newCar);
        newCar.setUserEntity(userEntity);
        carRepository.save(newCar);
        return newCar.getId();
    }

    @Override
    public boolean carExist(String vin) {
        return carRepository.findCarByVin(vin).isEmpty();
    }

    @Override
    public List<CarViewModel> findCarByBrand(String brand) {
        if (brand.contains("*")) {
            String substring = brand.substring(0, brand.length() - 1);
            return carRepository
                    .findCarEntitiesByBrandContaining(substring)
                    .stream()
                    .map(car -> modelMapper.map(car, CarViewModel.class))
                    .collect(Collectors.toList());
        }

        return carRepository
                .findByBrand(brand)
                .stream()
                .map(car -> modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarViewModel> findCarByBrandAndModel(String brand, String model) {
        return carRepository
                .findCarEntityByBrandAndModel(brand, model)
                .stream()
                .map(car -> modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarViewModel> findAllByEngine(String engine) {
        return carRepository
                .findCarEntitiesByEngine(engine)
                .stream()
                .map(car -> modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarViewModel> findCarByCoupeModel(String coupeModel) {
        return carRepository
                .findCarEntitiesByCoupeModelContains(coupeModel)
                .stream()
                .map(car -> modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarViewModel> findAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(car-> modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public String findCarByRegistrationNumber(String car) {
        CarEntity carEntity = carRepository.findCarByRegNumber(car).orElse(null);
        return carEntity.getRegNumber();
    }

    @Override
    public CarViewModel findCarById(Long id) {
        return carRepository
                .findCarById(id)
                .map(car -> modelMapper.map(car, CarViewModel.class))
                .orElse(null);
    }

    @Override
    public CarViewModelWithRepairs findCarWithRepairsById(Long id) {
        CarViewModelWithRepairs carViewModelWithRepairs = carRepository
                .findCarById(id)
                .map(car -> modelMapper.map(car, CarViewModelWithRepairs.class))
                .orElse(null);
        assert carViewModelWithRepairs != null;
        Set<RepairEntity> collect = carViewModelWithRepairs.getRepairs()
                .stream()
                .sorted(Comparator.comparing(RepairEntity::getId))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        carViewModelWithRepairs.setRepairs(collect);
        return carViewModelWithRepairs;
    }

    @Override
    public CarEntity findCarEntityById(Long id) {
        return carRepository
                .findCarById(id)
                .orElse(null);
    }

    @Override
    public void updateCar(CarAddServiceModel updatedCar) {
        CarEntity updatedNewCar = carRepository
                .findCarById(updatedCar.getId())
                .orElseThrow(IllegalArgumentException::new);
        setCar(updatedCar, updatedNewCar);
//        carRepository.save(updatedNewCar);

    }


    @Override
    public List<CarViewModel> findCarByRegNumber(String number) {
        return this.carRepository
                .findCarByRegNumber(number)
                .stream()
                .map(car -> modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarViewModel> findCarByVin(String vin) {
        return this.carRepository.findCarByVin(vin)
                .stream()
                .map(car -> modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());
    }

    private void setCar(CarAddServiceModel updatedCar, CarEntity updatedNewCar) {
        updatedNewCar.setBrand(updatedCar.getBrand().toUpperCase().trim())
                .setModel(updatedCar.getModel().toUpperCase().trim())
                .setCoupeModel(updatedCar.getCoupeModel().toUpperCase().trim())
                .setRegNumber(updatedCar.getRegNumber().toUpperCase().trim())
                .setVin(updatedCar.getVin().toUpperCase().trim())
                .setEngine(updatedCar.getEngine().toUpperCase().trim())
                .setFuel(updatedCar.getFuel())
                .setVolume(updatedCar.getVolume())
                .setPower(updatedCar.getPower())
                .setMileage(updatedCar.getMileage())
                .setTransmission(updatedCar.getTransmission())
                .setReleaseDate(updatedCar.getReleaseDate())
                .setClient(updatedCar.getClientEntity());
        carRepository.save(updatedNewCar);
    }

}
