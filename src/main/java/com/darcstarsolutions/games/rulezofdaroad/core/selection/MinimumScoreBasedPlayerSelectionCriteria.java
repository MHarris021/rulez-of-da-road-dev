package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public class MinimumScoreBasedPlayerSelectionCriteria extends
		ScoreBasedPlayerSelectionCriteria {

	public MinimumScoreBasedPlayerSelectionCriteria(long score) {
		super(score);
	}

	public MinimumScoreBasedPlayerSelectionCriteria(long score,
			boolean includeBound) {
		super(score, includeBound);
	}

	@Override
	public boolean matches(Player item) {
		boolean result = false;
		if (isBoundIncluded()) {
			result = getScore() <= item.getScore();
		} else {
			result = getScore() < item.getScore();
		}
		return result;
	}

}
