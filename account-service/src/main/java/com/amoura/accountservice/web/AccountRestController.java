package com.amoura.accountservice.web;


import com.amoura.accountservice.clients.CustomerRestClient;
import com.amoura.accountservice.entities.BanckAccount;
import com.amoura.accountservice.model.Customer;
import com.amoura.accountservice.repository.BanckAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AccountRestController {

    private final BanckAccountRepository banckAccountRepository;
    private  CustomerRestClient customerRestClient;


    public AccountRestController(BanckAccountRepository banckAccountRepository, CustomerRestClient customerRestClient) {
        this.banckAccountRepository = banckAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BanckAccount> accountList(){
        return banckAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BanckAccount banckAccountBayId(@PathVariable String id){
        BanckAccount  banckAccount= banckAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerByID(banckAccount.getCustomerId());
        banckAccount.setCustomer(customer);
        return banckAccount;
    }
}
