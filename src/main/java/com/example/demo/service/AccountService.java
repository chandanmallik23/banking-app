package com.example.demo.service;

import java.util.List;

import com.example.demo.banking_Entity.Account;

public interface AccountService {
	
	Account createAccount(Account account);
	
	Account getAccountById(Long id);
	
	List<Account> getAllAccounts();
	
	Account deposit(Long id, double amount);
	
	Account withdraw(Long id, double amount);

}
