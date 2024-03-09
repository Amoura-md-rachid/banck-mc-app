package com.amoura.accountservice.model;


import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
