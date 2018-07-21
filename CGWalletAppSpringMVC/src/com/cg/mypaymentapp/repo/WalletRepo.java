
//WalletRepo Interface

package com.cg.mypaymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;

public interface WalletRepo extends JpaRepository<Customer, String>
{

}
