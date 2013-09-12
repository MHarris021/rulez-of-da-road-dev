package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import com.darcstarsolutions.common.core.builders.Builder;
import com.darcstarsolutions.common.utils.ValidationUtils;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;

public abstract class RuleBuilder<T extends Serializable, S extends Rule<T>, U extends RuleBuilder<T, S, U>>
		extends Builder<S> {

	@Autowired
	private ValidationUtils validationUtils;

	public RuleBuilder() {
	}

	@SuppressWarnings("unchecked")
	public U createRule(@NotEmpty Object... objects)
			throws ConstraintViolationException {
		S rule = initializeRule(objects);
		if (validationUtils.validate(rule)) {
			setEntity(rule);
		}
		return (U) this;
	}

	protected abstract <P extends S> P initializeRule(@NotEmpty Object... objects)
			throws ConstraintViolationException;

	@SuppressWarnings("unchecked")
	public U setDescription(@NotBlank String description)
			throws ConstraintViolationException {
		S basicRule = getEntity();
		basicRule.setDescription(description);
		if (validationUtils.validate(basicRule)) {
			setEntity(basicRule);
		}
		return (U) this;
	}

	/**
	 * @return the validationUtils
	 */
	public ValidationUtils getValidationUtils() {
		return validationUtils;
	}

	/**
	 * @param validationUtils
	 *            the validationUtils to set
	 */
	public void setValidationUtils(ValidationUtils validationUtils) {
		this.validationUtils = validationUtils;
	}
}
