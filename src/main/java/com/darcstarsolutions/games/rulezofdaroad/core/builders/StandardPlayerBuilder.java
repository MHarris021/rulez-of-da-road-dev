package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;

@Component
@Scope(value = "prototype")
public class StandardPlayerBuilder extends
		PlayerBuilder<Player, PlayerTemplate, StandardPlayerBuilder> {

	@Override
	protected Player initializePlayer(@NotNull PlayerTemplate playerTemplate,
			Object... args) {
		Player player = new Player();
		List<Rule<Player>> rules = new ArrayList<Rule<Player>>(
				playerTemplate.getRules());
		String name = Player.DEFAULT_PLAYER_NAME;
		long score = 0;
		if ((args != null) && args.length > 0) {
			if (args[0] instanceof CharSequence) {
				name = (String) args[0];
			}
			if ((args.length > 1)) {
				if (args[1] instanceof Long) {
					score = (Long) args[1];
				} else if (args[1] instanceof Integer) {
					score = (Integer) args[1];
				}
			}
		}

		player.setName(name);
		player.setRules(rules);
		player.setScore(score);
		return player;
	}

}
