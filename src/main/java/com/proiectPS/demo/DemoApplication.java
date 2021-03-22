package com.proiectPS.demo;

import com.proiectPS.demo.model.Currency;
import com.proiectPS.demo.model.Transasction;
import com.proiectPS.demo.model.User;
import com.proiectPS.demo.repository.CurrencyRepository;
import com.proiectPS.demo.repository.TransactionRepository;
import com.proiectPS.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.stream.Stream;

@EntityScan
@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository,
						   CurrencyRepository currencyRepository){
		//injecteaza reporuile
		return args -> {

//			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//				User user = new User(name, name.toLowerCase() + "@domain.com");
//				userRepository.save(user);
//			});
//			userRepository.findAll().forEach(System.out::println);
//			ArrayList<Currency> currencies = new ArrayList<>();
//			Currency BitCoin = new Currency(null,"BitCoin",50000L);
//			Currency Etherium = new Currency(null,"Etherium",1200L);
//			currencies.add(BitCoin);
//			currencies.add(Etherium);
//			currencyRepository.saveAll(currencies);
//
//
//			ArrayList<Transasction> transasctions = new ArrayList<>();
//			Transasction tr1 =  new Transasction(null,BitCoin, 0.002d, null ,null);
//			Transasction tr2 =  new Transasction(null,Etherium, 0.00002d,null, null);
//			transasctions.add(tr1);
//			transasctions.add(tr2);
//			transactionRepository.saveAll(transasctions);
//
//
//			Transasction tr3 =  new Transasction(null,BitCoin, 2.002d, null ,null);
//			transactionRepository.save(tr3);
//			ArrayList<Transasction> transasctions2 = new ArrayList<>();
//			transasctions2.add(tr3);






		};
	}

}
