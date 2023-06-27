package com.inventory.main.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.main.models.Returns;

public interface ReturnsRepository extends JpaRepository<Returns, Integer>{

}
