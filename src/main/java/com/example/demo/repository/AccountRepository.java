package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.banking_Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
