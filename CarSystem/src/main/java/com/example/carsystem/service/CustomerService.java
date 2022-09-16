package com.example.carsystem.service;

import com.example.carsystem.model.CarCare;
import com.example.carsystem.model.Customer;
import com.example.carsystem.repository.CarCareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CarCareRepository repository;

    public Customer getCustomer(String email) {
        if (repository.findByCustomer_Email(email).isPresent())
            return repository.findByCustomer_Email(email).get().getCustomer();
        return null;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (CarCare care : repository.findAll()) {
            customers.add(care.getCustomer());
        }
        return customers;
    }

}
