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
	protected <P extends PlayerRule> P initializeRule(@NotEmpty String name,
			Object... objects) throws ConstraintViolationException {
		PlayerRule playerRule = new PlayerRule();
		String description = "";
		long points = 0;
		if ((objects.length > 0) && (objects[0] instanceof CharSequence)) {
			description = (String) objects[0];
		}
		if (objects.length > 1) {

			if (objects[1] instanceof Long) {
				points = (Long) objects[1];
			} else if (objects[1] instanceof Integer) {
				points = (Integer) objects[1];
			}
		}
		playerRule.setName(name);
		playerRule.setDescription(description);
		playerRule.setPoints(points);
		return (P) playerRule;
	}

}
