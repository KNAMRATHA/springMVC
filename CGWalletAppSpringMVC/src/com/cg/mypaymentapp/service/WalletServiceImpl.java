
package com.cg.mypaymentapp.service;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepo1;
//import com.cg.mypaymentapp.repo.WalletRepoImpl;


@Component(value="walletService")
public class WalletServiceImpl implements WalletService
{
	@Autowired
	private WalletRepo repo;
	@Autowired
	private WalletRepo1 repo1;//=new WalletRepoImpl();
//private WalletRepoImpl walletRepo;
	Customer customer;
	Transactions trans;

//WalletRepo repo1=new WalletRepoImpl();
//Map<String, Customer> data=new HashMap<>();
//	public WalletServiceImpl(Map<String, Customer> data)
//	{
//		repo= new WalletRepoImpl(data);
//	}
//	public WalletServiceImpl(WalletRepo repo) 
//	{
//		this.repo=repo;
//	}

	public WalletServiceImpl() {
		//repo=new WalletRepoImpl();
	}
	@Transactional
	@Override
	public Customer createAccount(Customer customer)
	{
//		customer=new Customer();
//		trans=new Transactions();
//		
//		if(name==null || mobileno==null || amount==null)
//		throw new NullPointerException();
//		if(isPhoneNumbervalid(mobileno)&&isAmountValid(amount) &&isNameValid(name))
//		
//		customer.setName(name);
//		customer.setMobileNo(mobileno);
//		customer.setWallet(new Wallet(amount));
//		//repo.startTransaction();
		repo.save(customer);
//		//repo.commitTransaction();
//		
//		
			//repo.startTransaction();
		trans=new Transactions(customer.getMobileNo(),"CREATE ACCOUNT",customer.getWallet().getBalance(),new Date().toString(),"Success");
			repo1.save(trans);
//			//repo.commitTransaction();
//			//return customer;
////			}
////		else
////			throw new InvalidInputException("Account is already existing");	
	return repo.save(customer);
		
	}	
	@Override
	public Customer showBalance(String mobileno) 
	{
		
		//repo.startTransaction();
		customer=repo.findOne(mobileno);
		//repo.commitTransaction();
		if(customer==null )
		throw new InvalidInputException("Invalid mobile no ");
		else	
		return customer;
		
	}
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount)
	{
	//Customer customer=null;
	Customer customer1=new Customer();
			customer=new Customer();
	//trans=new Transactions();
	//Transactions trans1=new Transactions();
	Transactions trans2=new Transactions();
	if(sourceMobileNo.equals(targetMobileNo))
	{
		throw new InvalidInputException("Source and target mobile numbers are equal");
	}
	
		//repo.startTransaction();
	customer=repo.findOne(sourceMobileNo);
	customer1=repo.findOne(targetMobileNo);
	//repo.commitTransaction();
	BigDecimal balance1;
	BigDecimal balance2;
	
    balance1=customer.getWallet().getBalance();
	balance2=customer1.getWallet().getBalance();
	
		if(( balance1).compareTo(amount)>=0) {
	balance1=balance1.subtract(amount);
	customer.setWallet(new Wallet(balance1));
	repo.save(customer);
	trans=new Transactions(customer.getMobileNo(),"fund transferred",customer.getWallet().getBalance(),new Date().toString(),"Success");
	repo1.save(trans);
	
	
	balance2=balance2.add(amount);	
	customer1.setWallet(new Wallet(balance2));
	repo.save(customer1);
	trans2=new Transactions(customer1.getMobileNo(),"fund received",customer.getWallet().getBalance(),new Date().toString(),"Success");
	repo1.save(trans2);
		}
		


	else
	System.out.println("Insufficient balance");
	
	
	return customer ;
}

public Customer depositAmount(String mobileNo, BigDecimal amount) {
	
	customer=new Customer();
	trans=new Transactions();
	
		//repo.startTransaction();
		customer=repo.findOne(mobileNo);
		//repo.commitTransaction();
	
	BigDecimal dbalance;
	dbalance=customer.getWallet().getBalance();
	//if(isAmountValid(amount))
	dbalance=dbalance.add(amount);
	customer.setWallet(new Wallet(dbalance));
	repo.save(customer);
trans=new Transactions(customer.getMobileNo(),"deposit",customer.getWallet().getBalance(),new Date().toString(),"Success");
	repo1.save(trans);
	return customer ;
	
}

public Customer withdrawAmount(String mobileNo, BigDecimal amount) 
{
	customer=new Customer();
	trans=new Transactions();
	
		//repo.startTransaction();
	customer=repo.findOne(mobileNo);
	//repo.commitTransaction();
	BigDecimal wbalance;
	wbalance=customer.getWallet().getBalance();
	//if(isAmountValid(amount))
	wbalance=wbalance.subtract(amount);
	customer.setWallet(new Wallet(wbalance));
	repo.save(customer);
	trans=new Transactions(customer.getMobileNo(),"Withdraw",customer.getWallet().getBalance(),new Date().toString(),"Success");
	repo1.save(trans);
	
	return customer ;
	
   }
@Transactional
public List<Transactions> recentTransactions(String mobileNumber) 
{
	if(!isPhoneNumbervalid(mobileNumber))
	throw new InvalidInputException("Invalid mobile number");
	
	else
	{
		//repo.startTransaction();
		List<Transactions> trans=repo1.findByMobileNumber(mobileNumber);
		
		//repo.commitTransaction();
		if( trans!=null)
			return trans;
		
		else
			throw new InvalidInputException("Invalid input");
	}
	
	
}


//	public boolean isValid() throws InvalidInputException
//	{
//		Customer customer=new Customer();
//		if( customer.getMobileNo() == null ||  (isPhoneNumbervalid( customer.getMobileNo() )==false ))
//			{
//			throw new InvalidInputException( "Phone Number is invalid" );
//			}
//		else if(customer.getName()==null || !isNameValid(customer.getName()))
//			{
//			throw new InvalidInputException( "Name is invalid");
//			}
//		else 
//			
//		return true;
//	}
		public boolean isPhoneNumbervalid( String phoneNumber )
		{
			if(phoneNumber.matches("[1-9][0-9]{9}")) 
			{
				return true;
			}		
			else 
				return false;
		}
		public boolean isNameValid(String name)
		{
			if(name.matches("^[a-zA-Z]{1,30}$"))
			{
				return true;
			}
			else
				return false;
		}
		public boolean isAmountValid(BigDecimal amount)
		{
			int val=amount.compareTo(new BigDecimal("0"));
			if(val==0|| val<0)
				return false;
			return true;
		}
		}
