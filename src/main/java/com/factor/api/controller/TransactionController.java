package com.factor.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factor.api.model.Transaction;
import com.factor.api.repository.TransactionRepository;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	TransactionRepository transactionRepository;

	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	@GetMapping("/transactions/{trustID}")
	public List<Transaction> getAllTransactionsByTrustId(@PathVariable(value = "trustID") String trustID) {

		Transaction transaction = new Transaction();
		transaction.setTrustIDFrom(trustID);

		Example<Transaction> example = Example.of(transaction);

		List<Transaction> transactions = transactionRepository.findAll(example);
		
		transaction.setTrustIDFrom(null);
		transaction.setTrustIDTo(trustID);
		example = Example.of(transaction);
		
		transactions.addAll(transactionRepository.findAll(example));
		
		return transactions;
	}

	// @PostMapping("/wallet/{id}")
	// public Wallet updateWallet(@PathVariable(value = "id") String trustID,
	// @Valid @RequestBody List<Wallet> walletDetails) {
	//
	// Wallet walletChild = null;
	// Float masterSum = 0.0F;
	//
	// for (Wallet walletDetail : walletDetails) {
	//
	// walletChild = walletRepository.findById(walletDetail.getTrustID()).get();
	// walletChild.setValue(walletChild.getValue() - walletDetail.getValue());
	// masterSum += walletDetail.getValue();
	// walletRepository.save(walletChild);
	// }
	//
	// Wallet walletMaster = walletRepository.findById(trustID).get();
	// walletMaster.setValue(walletMaster.getValue() + masterSum);
	//
	// Wallet updatedWallet = walletRepository.save(walletMaster);
	//
	// return updatedWallet;
	// }

}
