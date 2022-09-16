package com.example.carsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Customer {
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Surname cannot be empty")
    private String surname;
    @Indexed(unique = true)
    @Email
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @Size(min = 10,max = 10,message = "Phone number should have 10 digits")
    private String phone;
    private Gender gender;
}
