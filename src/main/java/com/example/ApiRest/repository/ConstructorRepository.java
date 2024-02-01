package com.example.ApiRest.repository;

import com.example.ApiRest.model.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {


}
