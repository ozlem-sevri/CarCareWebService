package com.example.carsystem.controller;

import com.example.carsystem.model.Car;
import com.example.carsystem.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carCare/cars")
public class CarController {
    private final CarService service;

    @GetMapping("/{licencePlate}")
    public ResponseEntity<Car> getCar(@PathVariable String licencePlate) {
        if (Objects.nonNull(service.getCar(licencePlate))) {
            return new ResponseEntity<>(service.getCar(licencePlate), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCar() {
        List<Car> cars = service.getAllCar();
        if (Objects.isNull(cars) || cars.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

}
