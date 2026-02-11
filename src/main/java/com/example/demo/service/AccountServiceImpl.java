package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banking_Entity.Account;
import com.example.demo.repository.AccountRepository;


@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account createAccount(Account account) {
		
		return accountRepository.save(account);
	}

	@Override
	public Account getAccountById(Long id) {
		
		return accountRepository.findById(id).orElse(null);
	}

	@Override
	public List<Account> getAllAccounts() {
		
		return accountRepository.findAll();
	}

	@Override
	public Account deposit(Long id, double amount) {
		Account account = getAccountById(id);
		account.setBalance(account.getBalance()+ amount);
		return accountRepository.save(account);
	}

	@Override
	public Account withdraw(Long id, double amount) {
		Account account = getAccountById(id);
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");	
		}
		
		account.setBalance(account.getBalance() - amount );
		return accountRepository.save(account);
	}

}
	
