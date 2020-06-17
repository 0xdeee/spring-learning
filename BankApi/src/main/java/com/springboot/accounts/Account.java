package com.springboot.accounts;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "account")
@EntityListeners(AuditingEntityListener.class)
public class Account {
	
	@Id
	private String username;
	private String name;
	private String password;
	private String accountNo;
	private String balance;
	public Account() {
		super();
	}
	public Account(String username, String name, String password, String accountNo, String balance) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	
}
