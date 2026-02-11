package com.example.demo.banking_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.banking_Entity.Account;
import com.example.demo.service.AccountService;

@RestController

public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
//	1. CREATE ACCOUNT
	
	@PostMapping("/")
	public Account createAccount(@RequestBody Account account) {

	return accountService.createAccount(account);
	}
	
//	2. GET ACCOUNT BY ID
	
	@GetMapping("/{id}")
	
	public Account getAccountById(@PathVariable Long id) {
		
		return accountService.getAccountById(id);
		
	}
	
//	3. GET ALL ACCOUNT
	
	@GetMapping("/all")
	
	public List<Account> getAllAccounts() {
		
		return accountService.getAllAccounts();
	}
	
	
//	4. DEPOSIT MONEY
	@PutMapping("/{id}/deposit")
	
	public Account deposit(@PathVariable Long id, @RequestParam double amount) {
		
		return accountService.deposit(id, amount);
		
	}
	
	
//	5. WITHDRAW MONEY
	
	@PutMapping("/{id}/withdraw")
	
	public Account withdraw(@PathVariable Long id, @RequestParam double amount) {
		
		return accountService.withdraw(id, amount);
	}
	
}
