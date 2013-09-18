package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerRule;

@Component
@Scope(value = "prototype")
public class PlayerRuleBuilder extends
		RuleBuilder<Player, PlayerRule, PlayerRuleBuilder> {

	public PlayerRuleBuilder setPoints(@NotNull long points) {
		PlayerRule playerRule = getEntity();
		playerRule.setPoints(points);
		if (getValidationUtils().validate(playerRule)) {
			setEntity(playerRule);
		}

		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <P extends PlayerRule> P initializeRule(
			@NotEmpty Object... objects) throws ConstraintViolationException {
		PlayerRule playerRule = new PlayerRule();
		String name = "Default";
		String description = "";
		long points = 0L;
		if (objects[0] instanceof CharSequence) {
			name = (String) objects[0];
		} else {
			throw new IllegalArgumentException(
					"Arguments must contain rule name");
		}

		if ((objects.length > 1) && (objects[1] instanceof CharSequence)) {
			description = (String) objects[1];
		}
		if (objects.length > 2) {

			if (objects[2] instanceof Long) {
				points = (Long) objects[2];
			} else if (objects[2] instanceof Integer) {
				points = (Integer) objects[2];
			}
		}
		playerRule.setName(name);
		playerRule.setDescription(description);
		playerRule.setPoints(points);
		return (P) playerRule;
	}

}
