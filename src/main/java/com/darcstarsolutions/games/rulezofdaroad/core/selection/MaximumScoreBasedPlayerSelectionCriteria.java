package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public class MaximumScoreBasedPlayerSelectionCriteria extends
		ScoreBasedPlayerSelectionCriteria {

	public MaximumScoreBasedPlayerSelectionCriteria(long score) {
		super(score);
	}

	public MaximumScoreBasedPlayerSelectionCriteria(long score,
			boolean includeBound) {
		super(score, includeBound);
	}

	@Override
	public boolean matches(Player item) {
		boolean result = false;
		if (isBoundIncluded()) {
			result = getScore() >= item.getScore();
		} else {
			result = getScore() > item.getScore();
		}
		return result;
	}

}
