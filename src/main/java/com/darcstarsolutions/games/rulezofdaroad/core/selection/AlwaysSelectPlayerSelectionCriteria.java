package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public class AlwaysSelectPlayerSelectionCriteria implements
		PlayerSelectionCriteria<Player> {

	@Override
	public boolean matches(Player item) {
		return true;
	}

}
