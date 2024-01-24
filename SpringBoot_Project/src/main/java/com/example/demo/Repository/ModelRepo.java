package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Country;

public interface ModelRepo extends JpaRepository<Country, Integer> {

}
