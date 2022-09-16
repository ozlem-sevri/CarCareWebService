package com.example.carsystem.service;

import com.example.carsystem.model.Car;
import com.example.carsystem.model.CarCare;
import com.example.carsystem.repository.CarCareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarCareRepository repository;

    public Car getCar(String licencePlate){
        if(repository.findByCar_LicencePlate(licencePlate).isPresent()){
            return repository.findByCar_LicencePlate(licencePlate).get().getCar();
        }
        return null;
    }

    public List<Car> getAllCar(){

        List<Car> cars = new ArrayList<>();
        for (CarCare care: repository.findAll()) {
            cars.add(care.getCar());
        }
        return cars;

    }


}
