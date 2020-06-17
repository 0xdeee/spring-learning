package com.springboot.accounts;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> getAllAccount(){

		List<Account> accounts = new ArrayList<>();
		accountRepository.findAll().forEach(accounts::add);
		return accounts;
	}


	public void addAccount(Account account) {

		accountRepository.save(account);
	}


	public Account getSpecificAccount(String userName) {
		return accountRepository.findById(userName).get();
	}

}
