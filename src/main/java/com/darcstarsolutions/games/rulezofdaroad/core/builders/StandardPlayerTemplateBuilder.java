package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;

@Component
@Scope(value = "prototype")
public class StandardPlayerTemplateBuilder extends
		PlayerTemplateBuilder<PlayerTemplate, StandardPlayerTemplateBuilder> {

	@SuppressWarnings("unchecked")
	@Override
	protected PlayerTemplate initializePlayerTemplate(Object... args) {
		PlayerTemplate playerTemplate = new PlayerTemplate();
		List<Rule<Player>> rules;
		int number = PlayerTemplate.DEFAULT_PLAYER_NUMBER;
		String description = "";

		if (args[0] instanceof List<?>) {
			rules = (List<Rule<Player>>) args[0];
		} else {
			throw new IllegalArgumentException(
					"Arguments must contain rule name");
		}
		playerTemplate.setRules(rules);
		if ((args.length > 1) && (args[1] instanceof CharSequence)) {
			description = (String) args[1];
		}
		playerTemplate.setDescription(description);
		if ((args.length > 2) && (args[2] instanceof Integer)) {
			number = (Integer) args[2];
		}
		playerTemplate.setNumber(number);
		return playerTemplate;
	}

}
