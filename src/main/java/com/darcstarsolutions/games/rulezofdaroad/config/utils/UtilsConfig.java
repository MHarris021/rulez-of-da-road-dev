package com.darcstarsolutions.games.rulezofdaroad.config.utils;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.darcstarsolutions.common.utils.ValidationUtils;

@Configuration
public class UtilsConfig {

	@Bean(name = "validator")
	public Validator validator() {
		ValidatorFactory validatorFactory = Validation
				.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		return validator;
	}

	@Bean(name = "validationUtils")
	public ValidationUtils validationUtils() {
		ValidationUtils validationUtils = new ValidationUtils(validator());
		return validationUtils;
	}

}
