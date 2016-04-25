package com.example.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domain.MenuItem;

@RepositoryRestResource
public interface MenuRepo extends JpaRepository<MenuItem, Long>{};
