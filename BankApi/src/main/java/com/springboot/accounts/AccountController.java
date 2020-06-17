package com.springboot.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Value("${welcome.message}")
	private String welcome;
	
	@Value("${loginerror.message}")
	private String loginError;
	
	@Value("${signuperror.message}")
	private String signupError;
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("welcome", welcome);
		return "index";
	}
	
	//--------------------------- These 2 methods are for testing in POSTMAN --------------------------
	@RequestMapping(value = {"/accountList"}, method = RequestMethod.GET)
	public List<Account> getAllAccount(){
		return accountService.getAllAccount();
	}
	
	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	public void addAccount(@RequestBody Account account) {
		accountService.addAccount(account);
	}
	//--------------------------------------------------------------------------------------------------
	
	@RequestMapping("/accounts/{id}")
	public Account getSpecficAccount(@PathVariable String id) {
		return accountService.getSpecificAccount(id);
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String showLoginPage(Model model) {
		AccountLoginForm accountLoginForm = new AccountLoginForm();
		model.addAttribute("accountLoginForm", accountLoginForm);
		return "login";
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String loginValidation(Model model, @ModelAttribute("accountLoginForm") AccountLoginForm accountLoginForm) {
		String username = accountLoginForm.getUsername();
		String password = accountLoginForm.getPassword();
		
		if(username.length()>0 && password.length()>0) {
			Account account = accountService.getSpecificAccount(username);
			if(account.getPassword().equals(password)) {
				model.addAttribute("name", account.getName());
				model.addAttribute("balance", account.getBalance());
				return "userHome";
			}
		}
		
		model.addAttribute("errorMessage", loginError );
		return "login";
	}
	
	@RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
	public String showSignupPage(Model model) {
		AccountForm accountForm = new AccountForm();
		model.addAttribute("accountForm", accountForm);
		return "signup";
	}
	
	@RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
	public String addAccount(Model model, @ModelAttribute("accountForm") AccountForm accountForm) {
		String username = accountForm.getUsername();
		String name = accountForm.getName();
		String password = accountForm.getPassword();
		String accountNo = accountForm.getAccountNo();
		String balance = accountForm.getBalance();
		
		if (username.length()>0 && name.length()>0 && password.length()>0 && accountNo.length()>0 && balance.length()>0) {
			Account account = new Account(username,name,password,accountNo,balance);
			accountService.addAccount(account);
			return "signupSuccess";
		}
		model.addAttribute("signupError", signupError);
		return "signup";
	}
	
	@RequestMapping(value = {"/error"}, method = RequestMethod.GET)
	public String error() {
		return "error";
	}
}
