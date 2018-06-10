package com.factr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factr.api.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

}
