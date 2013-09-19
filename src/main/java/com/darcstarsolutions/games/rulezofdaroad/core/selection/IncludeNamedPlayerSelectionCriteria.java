package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import org.hibernate.validator.constraints.NotEmpty;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public class IncludeNamedPlayerSelectionCriteria extends
		NamedPlayerSelectionCriteria {

	public IncludeNamedPlayerSelectionCriteria(@NotEmpty String name) {
		super(name);
	}

	@Override
	public boolean matches(Player item) {
		boolean result = getName().equalsIgnoreCase(item.getName());
		return result;
	}

}
