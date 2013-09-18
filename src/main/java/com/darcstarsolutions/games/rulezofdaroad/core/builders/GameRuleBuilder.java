package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.darcstarsolutions.games.rulezofdaroad.core.Game;
import com.darcstarsolutions.games.rulezofdaroad.core.GameRule;
import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;

public class GameRuleBuilder extends RuleBuilder<Game, GameRule, GameRuleBuilder> {

	@SuppressWarnings("unchecked")
	@Override
	protected <P extends GameRule> P initializeRule(Object... objects)
			throws ConstraintViolationException {
		GameRule gameRule = new GameRule();
		String name = "Environment";
		String description = "";
		List<Rule<Player>> playerRules = null;
		gameRule.setName(name);
		gameRule.setDescription(description);
		gameRule.setPlayerRules(playerRules);
		return (P) gameRule;
	}

}
