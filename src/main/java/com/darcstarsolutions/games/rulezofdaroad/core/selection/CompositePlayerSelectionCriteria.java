package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import java.util.Collection;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public abstract class CompositePlayerSelectionCriteria implements
		PlayerSelectionCriteria<Player> {

	private Collection<PlayerSelectionCriteria<Player>> criterias;

	public CompositePlayerSelectionCriteria(
			Collection<PlayerSelectionCriteria<Player>> criterias) {
		setCriterias(criterias);
	}

	public Collection<PlayerSelectionCriteria<Player>> getCriterias() {
		return criterias;
	}

	public void setCriterias(Collection<PlayerSelectionCriteria<Player>> criterias) {
		this.criterias = criterias;
	}

}
