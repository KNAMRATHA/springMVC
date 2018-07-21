package com.cg.mypaymentapp.controllers;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.beans.Wallet;

@Controller
public class URIController {
	
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping(value="/loginPage")
	public String getLoginPage() {
		return "loginPage";
	}
	@RequestMapping(value="/registrationPage")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	@RequestMapping(value="/deposit")
	public String getDeposit() {
		return "deposit";
	}
	@RequestMapping(value="/withdraw")
	public String getWithdraw() {
		return "withdraw";
	}
	@RequestMapping(value="/fundTransfer")
	public String getFundTransfer() {
		return "fundTransfer";
	}
	
	@ModelAttribute("customer")
	public Customer getCustomer()
	{
		return new Customer();
	}
	@ModelAttribute("transactions")
	public Transactions getTransactions()
	{
		return new Transactions();
	}
	
	/*@RequestMapping(value="/printTransaction")
	public String getPrintTransaction() {
		return "printTransaction";
	}*/
	public String getMobileNo(@RequestParam(value="mobileNo",required=true)String mobileNo) {
		
		return mobileNo;
	}
	
//	public BigDecimal getBalance(@RequestParam(value="balance",required=true)BigDecimal balance) 
//	{
//		return balance;
//	}
}
