package com.darcstarsolutions.users.repositories.jpa;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.darcstarsolutions.users.core.UserAccount;

@Repository
public interface UserAccountRepository extends
		PagingAndSortingRepository<UserAccount, BigInteger> {

}
