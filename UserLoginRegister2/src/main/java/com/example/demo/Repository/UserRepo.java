package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.Model.User;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByName(String name);

}
