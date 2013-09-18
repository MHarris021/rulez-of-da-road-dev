package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.validator.constraints.NotEmpty;

import com.darcstarsolutions.common.core.builders.Builder;
import com.darcstarsolutions.common.utils.ValidationUtils;
import com.darcstarsolutions.games.rulezofdaroad.core.Game;
import com.darcstarsolutions.games.rulezofdaroad.core.GameTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;

public abstract class GameTemplateBuilder<T extends GameTemplate, U extends GameTemplateBuilder<T, U>>
		extends Builder<T> {

	@Resource
	private ValidationUtils validationUtils;

	public GameTemplateBuilder() {
	}

	@SuppressWarnings("unchecked")
	public U createGameTemplate(List<PlayerTemplate> playerTemplates,
			Object... args) {
		T gameTemplate = initializeGameTemplate(playerTemplates, args);
		if (validationUtils.validate(gameTemplate)) {
			setEntity(gameTemplate);
		}
		return (U) this;
	}

	protected abstract T initializeGameTemplate(
			List<PlayerTemplate> playerTemplates, Object... args);

	@SuppressWarnings("unchecked")
	public U setDescription(@NotEmpty String description) {
		T gameTemplate = getEntity();
		gameTemplate.setDescription(description);
		if (validationUtils.validate(gameTemplate)) {
			setEntity(gameTemplate);
		}
		return (U) this;
	}

	@SuppressWarnings("unchecked")
	public U setRules(List<Rule<Game>> rules) {
		T gameTemplate = getEntity();
		gameTemplate.setRules(rules);
		if (validationUtils.validate(gameTemplate)) {
			setEntity(gameTemplate);
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
