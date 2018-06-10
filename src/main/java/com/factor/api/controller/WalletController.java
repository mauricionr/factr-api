package com.factor.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factor.api.model.Transaction;
import com.factor.api.model.Wallet;
import com.factor.api.repository.TransactionRepository;
import com.factor.api.repository.WalletRepository;

@RestController
@RequestMapping("/api")
public class WalletController {

	@Autowired
	WalletRepository walletRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@GetMapping("/wallets")
	public List<Wallet> getAllWallets() {
		return walletRepository.findAll();
	}

	@PostMapping("/wallet/{id}")
	public Wallet updateWallet(@PathVariable(value = "id") String trustID,
			@Valid @RequestBody List<Wallet> walletDetails) {

		Wallet walletChild = null;
		Transaction transaction = null;
		Float masterSum = 0.0F;

		for (Wallet walletDetail : walletDetails) {

			walletChild = walletRepository.findById(walletDetail.getTrustID()).get();
			walletChild.setValue(walletChild.getValue() - walletDetail.getValue());
			masterSum += walletDetail.getValue();
			walletRepository.save(walletChild);

			transaction = new Transaction();
			transaction.setTrustIDFrom(walletChild.getTrustID());
			transaction.setTrustIDTo(trustID);
			transaction.setValue(walletDetail.getValue());
			transactionRepository.save(transaction);
		}

		Wallet walletMaster = walletRepository.findById(trustID).get();
		walletMaster.setValue(walletMaster.getValue() + masterSum);

		Wallet updatedWallet = walletRepository.save(walletMaster);

		return updatedWallet;
	}

}
