package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import org.hibernate.validator.constraints.NotEmpty;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public abstract class NamedPlayerSelectionCriteria implements
		PlayerSelectionCriteria<Player> {

	private String name;

	public NamedPlayerSelectionCriteria(@NotEmpty String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
