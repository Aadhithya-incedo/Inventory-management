package com.inventory.main.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.main.models.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
