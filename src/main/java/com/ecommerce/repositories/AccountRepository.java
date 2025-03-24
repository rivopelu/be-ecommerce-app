package com.ecommerce.repositories;

import com.ecommerce.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByEmailAndActiveIsTrue(String email);
}
