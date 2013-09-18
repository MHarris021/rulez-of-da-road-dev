package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.darcstarsolutions.games.rulezofdaroad.core.Game;
import com.darcstarsolutions.games.rulezofdaroad.core.GameTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;

@Component
@Scope(value = "prototype")
public class StandardGameTemplateBuilder extends
		GameTemplateBuilder<GameTemplate, StandardGameTemplateBuilder> {

	@Override
	protected GameTemplate initializeGameTemplate(
			List<PlayerTemplate> playerTemplates, Object... args) {
		GameTemplate gameTemplate = new GameTemplate();
		String description = "";
		List<Rule<Game>> rules = null;
		int uniquePlayers = GameTemplate.DEFAULT_UNIQUE_PLAYERS;
		gameTemplate.setDescription(description);
		gameTemplate.setPlayerTemplates(playerTemplates);
		gameTemplate.setUniquePlayers(uniquePlayers);
		gameTemplate.setRules(rules);
		return gameTemplate;
	}

}
