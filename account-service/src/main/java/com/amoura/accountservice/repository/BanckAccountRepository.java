package com.amoura.accountservice.repository;

import com.amoura.accountservice.entities.BanckAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface BanckAccountRepository extends JpaRepository<BanckAccount,String > {
}
