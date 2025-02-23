package com.ecommerce.blooms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotBlank(message = "Username must have a value!")
    private String username;

    @NotBlank(message = "Password must have a value!")
    private String password;

    @Email
    @NotBlank(message = "Email must have a value!")
    private String email;
}
