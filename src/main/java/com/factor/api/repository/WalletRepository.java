package com.factor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factor.api.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

}
