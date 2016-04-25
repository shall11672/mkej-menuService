package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.domain.MenuItem;
import com.example.repo.MenuRepo;

@EnableDiscoveryClient
@SpringBootApplication
public class MenuServiceApplication implements CommandLineRunner {

	@Autowired
	private MenuRepo menuRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MenuServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Stream.of("Taco", "Burrito", "Enchillada", "Fajitas").forEach(name -> this.menuRepo.save(new MenuItem(name)));
		menuRepo.findAll().forEach(menu -> System.out.println(menu));
	}
}

