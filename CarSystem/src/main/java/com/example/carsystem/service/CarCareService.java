package com.example.carsystem.service;

import com.example.carsystem.model.Car;
import com.example.carsystem.model.CarCare;
import com.example.carsystem.model.Customer;
import com.example.carsystem.model.Product;
import com.example.carsystem.repository.CarCareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarCareService {
    private final CarCareRepository repository;


    public CarCare addCarCare(CarCare carCare) {
        if (repository.findByCar_LicencePlate(carCare.getCar().getLicencePlate()).isEmpty())
            return repository.save(carCare);
        return null;
    }

    public CarCare getCarCare(String licencePlate) {
        if (repository.findByCar_LicencePlate(licencePlate).isPresent())
            return repository.findByCar_LicencePlate(licencePlate).get();
        return null;
    }

    public List<CarCare> getAllCarCares() {
        return repository.findAll();
    }

    public CarCare updateCarCareWithCar(String id, Car car) {
        if (repository.findById(id).isPresent()) {
            return repository.save(repository.findById(id).get().toBuilder().car(car).build());
        }
        return null;
    }

    public CarCare updateCarCareWithCustomer(String id, Customer customer) {
        if (repository.findById(id).isPresent())
            return repository.save(repository.findById(id).get().toBuilder().customer(customer).build());
        return null;
    }

    public CarCare addProduct(String licencePlate, Product product) {
        if (repository.findByCar_LicencePlate(licencePlate).isPresent()) {
            List<Product> products = repository.findByCar_LicencePlate(licencePlate).get().getProducts();
            products.add(product);

            return repository.save(repository.findByCar_LicencePlate(licencePlate).get().toBuilder().products(products).build());
        }
        return null;
    }

    public CarCare cancelProduct(String licencePlate, String product_name) {
        if (repository.findByCar_LicencePlate(licencePlate).isPresent()) {
            List<Product> products = repository.findByCar_LicencePlate(licencePlate).get().getProducts();
            for (Product p : products) {
                if (p.getName().equals(product_name)) {
                    products.remove(p);
                    break;
                }
            }
            return repository.save(repository.findByCar_LicencePlate(licencePlate).get().toBuilder().products(products).build());
        }
        return null;
    }

    public boolean deleteCarCare(String id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


}
