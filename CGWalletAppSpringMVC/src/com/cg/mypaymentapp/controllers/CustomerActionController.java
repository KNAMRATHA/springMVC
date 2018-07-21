package com.cg.mypaymentapp.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.service.WalletService;

@Controller
public class CustomerActionController {
	public static String mobileNo;
	@Autowired
	WalletService walletService;
	
	@RequestMapping(value="/registerCustomer")
public ModelAndView registerCustomer(@Valid @ModelAttribute("customer")Customer customer,BindingResult result) {
		if(result.hasErrors())
			return new ModelAndView("registrationPage");
		customer=walletService.createAccount(customer);
	return new ModelAndView("registrationSuccessPage", "customer",customer);
	
}
	@RequestMapping(value="/loginCustomer")
	public ModelAndView loginCustomer(@ModelAttribute("customer")Customer customer) {
		mobileNo=customer.getMobileNo();
			customer=walletService.showBalance(mobileNo);
		return new ModelAndView("loginSuccessPage", "customer",customer);
		
	}

	@RequestMapping(value="/fundTransferAction")
	public ModelAndView fundTransfer(@ModelAttribute("customer")Customer customer,@RequestParam("mobileNo")String target,@RequestParam("wallet.balance")BigDecimal amount) {
			
		Customer customer1=walletService.fundTransfer(mobileNo, target, customer.getWallet().getBalance());
		return new ModelAndView("currentbalance", "customer",customer1);
		
	}
	@RequestMapping(value="/depositAmount")
	public ModelAndView depositBalance(@ModelAttribute("customer")Customer customer,@RequestParam("wallet.balance")BigDecimal amount) {
		
		
		
		Customer customer1=walletService.depositAmount(mobileNo,amount);
		
		return new ModelAndView("currentbalance", "customer",customer1);
		
	}
	@RequestMapping(value="/withdrawAmount")
	public ModelAndView withdrawBalance(@ModelAttribute("customer")Customer customer,@RequestParam("wallet.balance")BigDecimal amount) {
				Customer customer1=walletService.withdrawAmount(mobileNo,amount);
		return new ModelAndView("currentbalance", "customer",customer1);
		
	}
	@RequestMapping(value="/printTransaction")
	public ModelAndView printtrans() {
		List<Transactions> transaction=walletService.recentTransactions(mobileNo);
		return new ModelAndView("printTransaction","transactions",transaction);
	}
	
}
