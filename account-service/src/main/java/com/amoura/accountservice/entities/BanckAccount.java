package com.amoura.accountservice.entities;

import com.amoura.accountservice.enums.AccountType;
import com.amoura.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder

@Entity
public class BanckAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
