package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import com.darcstarsolutions.common.core.builders.Builder;
import com.darcstarsolutions.common.utils.ValidationUtils;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;

public abstract class PlayerTemplateBuilder<T extends PlayerTemplate, U extends PlayerTemplateBuilder<T, U>>
		extends Builder<T> {

	@Autowired
	private ValidationUtils validationUtils;

	public PlayerTemplateBuilder() {
	}

	@SuppressWarnings("unchecked")
	public U createPlayerTemplate(@NotEmpty Object... args) {
		T playerTemplate = initializePlayerTemplate(args);
		if (validationUtils.validate(playerTemplate)) {
			setEntity(playerTemplate);
		}
		return (U) this;
	}

	protected abstract T initializePlayerTemplate(@NotEmpty Object... args);

	@SuppressWarnings("unchecked")
	public U setDescription(@NotNull String description) {
		T playerTemplate = getEntity();
		playerTemplate.setDescription(description);
		if (validationUtils.validate(playerTemplate)) {
			setEntity(playerTemplate);
		}
		return (U) this;
	}

	@SuppressWarnings("unchecked")
	public U setNumber(@NotNull int number) {
		T playerTemplate = getEntity();
		playerTemplate.setNumber(number);
		if (validationUtils.validate(playerTemplate)) {
			setEntity(playerTemplate);
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
