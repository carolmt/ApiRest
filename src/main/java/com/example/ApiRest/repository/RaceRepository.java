package com.example.ApiRest.repository;

import com.example.ApiRest.model.Driver;
import com.example.ApiRest.model.Race;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {

}
