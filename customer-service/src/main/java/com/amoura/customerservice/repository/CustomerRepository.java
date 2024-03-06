package com.amoura.customerservice.repository;

import com.amoura.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource // utlise dans le cas de POC
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
