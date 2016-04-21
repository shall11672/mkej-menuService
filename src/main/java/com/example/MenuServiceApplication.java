package com.example;

import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableDiscoveryClient
@SpringBootApplication
public class MenuServiceApplication implements CommandLineRunner{

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

@RepositoryRestResource
interface MenuRepo extends JpaRepository<MenuItem, Long>{};

@Entity
class MenuItem{
	
	MenuItem(){//why JPA?  why?
	}
	
	
	public MenuItem(String name)
	{
		this.name = name;
	}
	
	@Id @GeneratedValue	
	Long Id;
	String name;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.Id + "  " + this.name;
	}
}
