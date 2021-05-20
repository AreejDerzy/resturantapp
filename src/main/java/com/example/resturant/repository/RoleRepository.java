package com.example.resturant.repository;

import com.example.resturant.model.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<role, Integer> {
}
