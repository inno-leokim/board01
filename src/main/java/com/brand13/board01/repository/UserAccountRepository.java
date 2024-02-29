package com.brand13.board01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brand13.board01.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{}
