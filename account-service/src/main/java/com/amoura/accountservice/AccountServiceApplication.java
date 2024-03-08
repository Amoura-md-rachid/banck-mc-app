package com.amoura.accountservice;

import com.amoura.accountservice.entities.BanckAccount;
import com.amoura.accountservice.enums.AccountType;
import com.amoura.accountservice.repository.BanckAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BanckAccountRepository banckAccountRepository){
		return args -> {

			BanckAccount banckAccount1 = BanckAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("DZD")
					.balance(80000)
					.createAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BanckAccount banckAccount2 = BanckAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("DZD")
					.balance(78000)
					.createAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(2))
					.build();

			banckAccountRepository.save(banckAccount1);
			banckAccountRepository.save(banckAccount2);

		};
	}

}
