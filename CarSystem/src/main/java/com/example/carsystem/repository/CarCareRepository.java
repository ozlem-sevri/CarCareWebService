package com.example.carsystem.repository;

import com.example.carsystem.model.CarCare;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarCareRepository extends MongoRepository<CarCare, String> {
    Optional<CarCare> findByCar_LicencePlate(String licencePlate);

    Optional<CarCare> findByCustomer_Email(String email);

}
