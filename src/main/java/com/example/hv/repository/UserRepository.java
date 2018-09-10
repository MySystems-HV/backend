package com.example.hv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hv.models.User;

public interface UserRepository extends JpaRepository<User, String> {

}
