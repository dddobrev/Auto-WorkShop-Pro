package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.entities.CarEntity;
import com.example.AutoWorkShop.repository.CarRepository;
import com.example.AutoWorkShop.view.CarViewModelWithRepairs;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarRestController {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarRestController(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api")
    public ResponseEntity<List<CarEntity>> findAll() {
        List<CarViewModelWithRepairs> carViewModelWithRepairs =
                carRepository
                        .findAll()
                        .stream()
                        .map(car -> {
                            CarViewModelWithRepairs carViewModelWithRepair =
                                    modelMapper.map(car, CarViewModelWithRepairs.class);
                            carViewModelWithRepair.setClientEntity(car.getClient());
                            return carViewModelWithRepair;
                        })
                        .collect(Collectors.toList());


        return ResponseEntity
                .ok()
                .body(carRepository.findAll());
    }
}
