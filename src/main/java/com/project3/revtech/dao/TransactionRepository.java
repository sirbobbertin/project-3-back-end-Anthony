package com.project3.revtech.dao;

import java.util.List;

import com.project3.revtech.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

// 	@Query("select * from transaction_details where cart_id = ?")
	List<Transaction> findAllTransactionsForCart(Integer cartId);
	
	
}
