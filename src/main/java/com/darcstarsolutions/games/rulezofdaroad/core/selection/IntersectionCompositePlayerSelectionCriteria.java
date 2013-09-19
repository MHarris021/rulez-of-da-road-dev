package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import java.util.Collection;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public class IntersectionCompositePlayerSelectionCriteria extends
		CompositePlayerSelectionCriteria {

	public IntersectionCompositePlayerSelectionCriteria(
			Collection<PlayerSelectionCriteria<Player>> criterias) {
		super(criterias);
	}

	@Override
	public boolean matches(Player item) {
		boolean result = false;
		for (PlayerSelectionCriteria<Player> criteria : getCriterias()) {
			result = criteria.matches(item);
			if (!result) {
				break;
			}
		}
		return result;
	}

}
