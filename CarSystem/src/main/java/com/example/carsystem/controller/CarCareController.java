package com.example.carsystem.controller;

import com.example.carsystem.model.Car;
import com.example.carsystem.model.CarCare;
import com.example.carsystem.model.Customer;
import com.example.carsystem.model.Product;
import com.example.carsystem.service.CarCareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carCare")
public class CarCareController {
    private final CarCareService service;

    @PostMapping
    public ResponseEntity<CarCare> addCarCare(@Valid @RequestBody CarCare carCare) {
        CarCare care = service.addCarCare(carCare);
        if (Objects.nonNull(care))
            return new ResponseEntity<>(care, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{licencePlate}")
    public ResponseEntity<CarCare> getCarCare(@PathVariable String licencePlate) {
        CarCare care = service.getCarCare(licencePlate);
        if (Objects.nonNull(care))
            return new ResponseEntity<>(care, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<CarCare>> getAllCarCares() {
        List<CarCare> carCares = service.getAllCarCares();
        if (Objects.isNull(carCares) || carCares.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(carCares, HttpStatus.OK);
    }

    @PatchMapping("/cars/{id}")
    public ResponseEntity<CarCare> updateCarCareWithCar(@PathVariable String id, @Valid @RequestBody Car car) {
        CarCare care = service.updateCarCareWithCar(id, car);
        if (Objects.nonNull(care))
            return new ResponseEntity<>(care, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/customer/{id}")
    public ResponseEntity<CarCare> updateCarCareWithCustomer(@PathVariable String id, @Valid @RequestBody Customer customer) {
        CarCare care = service.updateCarCareWithCustomer(id, customer);
        if (Objects.nonNull(care))
            return new ResponseEntity<>(care, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{licencePlate}")
    public ResponseEntity<CarCare> addProduct(@PathVariable String licencePlate, @Valid @RequestBody Product product) {
        CarCare care = service.addProduct(licencePlate, product);
        if (Objects.nonNull(care))
            return new ResponseEntity<>(care, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{licencePlate}/{product_name}")
    public ResponseEntity<CarCare> cancelProduct(@PathVariable String licencePlate, @PathVariable String product_name) {
        CarCare care = service.cancelProduct(licencePlate, product_name);
        if (Objects.nonNull(care))
            return new ResponseEntity<>(care, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarCare(@PathVariable String id) {
        if (service.deleteCarCare(id))
            return new ResponseEntity<>("Car service record is deleted by id " + id, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
