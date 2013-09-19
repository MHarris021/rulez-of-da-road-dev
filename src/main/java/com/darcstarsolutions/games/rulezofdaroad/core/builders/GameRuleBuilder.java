package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.darcstarsolutions.games.rulezofdaroad.core.Game;
import com.darcstarsolutions.games.rulezofdaroad.core.GameRule;
import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerRule;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;

@Component
@Scope(value = "prototype")
public class GameRuleBuilder extends
		RuleBuilder<Game, GameRule, GameRuleBuilder> {

	@SuppressWarnings("unchecked")
	@Override
	protected <P extends GameRule> P initializeRule(@NotEmpty String name,
			Object... objects) throws ConstraintViolationException {
		GameRule gameRule = new GameRule();
		String description = "";
		List<Rule<Player>> playerRules = new ArrayList<>();
		if ((objects != null) && (objects.length > 0)) {
			if (objects[0] instanceof CharSequence) {
				description = (String) objects[0];
			}
			if ((objects.length > 1) && (objects[1] instanceof List<?>)) {
				playerRules = (List<Rule<Player>>) objects[1];
			}
		}
		gameRule.setName(name);
		gameRule.setDescription(description);
		gameRule.setPlayerRules(playerRules);
		return (P) gameRule;
	}

	public GameRuleBuilder setPlayerRules(PlayerRule... playerRules) {
		List<PlayerRule> rules = Arrays.asList(playerRules);
		return setPlayerRules(rules);
	}

	public GameRuleBuilder setPlayerRules(List<? extends Rule<Player>> rules) {
		GameRule gameRule = getEntity();
		gameRule.setPlayerRules(rules);
		if (getValidationUtils().validate(gameRule)) {
			setEntity(gameRule);
		}
		return this;
	}

}
