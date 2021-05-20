package com.example.resturant.repository;

import com.example.resturant.model.manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<manager, Integer> {
}
