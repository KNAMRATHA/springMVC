package com.cg.mypaymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.mypaymentapp.beans.Transactions;

public interface WalletRepo1 extends JpaRepository<Transactions,String>,CrudRepository<Transactions,String>{

	List<Transactions> findByMobileNumber(String mobileNumber) ;
}
