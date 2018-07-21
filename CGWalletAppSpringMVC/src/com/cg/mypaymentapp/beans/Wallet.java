
//Wallet class bean

package com.cg.mypaymentapp.beans;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Wallet")
public class Wallet implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="wallet")
private BigDecimal balance;

public Wallet(BigDecimal amount) 
{
	this.balance=amount;
}
//getters and setters for balance
public BigDecimal getBalance() 
{
	return balance;
}

public void setBalance(BigDecimal balance) 
{
	this.balance = balance;
}

@Override
	public String toString() 
{
	return ", balance="+balance;
}

public Wallet() 
{
	super();
	
}



}
