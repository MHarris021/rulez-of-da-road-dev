package com.darcstarsolutions.users.controllers.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.darcstarsolutions.users.core.UserAccount;
import com.darcstarsolutions.users.repositories.jpa.UserAccountRepository;

@RequestMapping(value = "useraccounts", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserAccountRestController {

	@Resource
	private UserAccountRepository userAccountRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<UserAccount>> userAccounts() {
		List<UserAccount> userAccounts = new ArrayList<UserAccount>(
				(Collection<? extends UserAccount>) userAccountRepository
						.findAll());
		ResponseEntity<List<UserAccount>> responseEntity = new ResponseEntity<List<UserAccount>>(
				userAccounts, HttpStatus.OK);

		URI location = linkTo(UserAccountRestController.class).toUri();
		responseEntity.getHeaders().setLocation(location);
		return responseEntity;
	}
}
