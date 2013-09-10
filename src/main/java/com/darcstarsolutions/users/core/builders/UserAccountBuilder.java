package com.darcstarsolutions.users.core.builders;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.darcstarsolutions.common.core.builders.Builder;
import com.darcstarsolutions.common.utils.ValidationUtils;
import com.darcstarsolutions.users.core.UserAccount;

@Component(value = "userAccountBuilder")
@Scope(value = "prototype")
public class UserAccountBuilder extends Builder<UserAccount> {

	@Autowired
	private ValidationUtils validationUtils;

	public UserAccountBuilder() {
	}

	/**
	 * @param name
	 * @param password
	 * @return
	 * @throws ConstraintViolationException
	 */
	public UserAccountBuilder createUserAccount(@NotBlank String name,
			@NotBlank String password) throws ConstraintViolationException {
		UserAccount userAccount = new UserAccount(name, password);
		if (validationUtils.validate(userAccount)) {
			setEntity(userAccount);
		}
		return this;
	}

	/**
	 * @param email
	 * @return
	 * @throws ConstraintViolationException
	 */
	public UserAccountBuilder setEmail(@Email String email)
			throws ConstraintViolationException {
		getEntity().setEmail(email);
		if (validationUtils.validate(getEntity())) {
			setEntity(getEntity());
		}
		return this;
	}

	/**
	 * @return the validationUtils
	 */
	public ValidationUtils getValidationUtils() {
		return validationUtils;
	}

	/**
	 * @param validationUtils the validationUtils to set
	 */
	public void setValidationUtils(ValidationUtils validationUtils) {
		this.validationUtils = validationUtils;
	}
	
	

}
