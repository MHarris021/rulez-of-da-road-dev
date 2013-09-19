package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public class RangeScoreBoundPlayerSelectionCriteria implements
		PlayerSelectionCriteria<Player> {

	private MinimumScoreBasedPlayerSelectionCriteria minimumScoreBasedPlayerSelectionCriteria;
	private MaximumScoreBasedPlayerSelectionCriteria maximumScoreBasedPlayerSelectionCriteria;

	public RangeScoreBoundPlayerSelectionCriteria(
			MinimumScoreBasedPlayerSelectionCriteria minimumScoreBasedPlayerSelectionCriteria,
			MaximumScoreBasedPlayerSelectionCriteria maximumScoreBasedPlayerSelectionCriteria) {
		setMinimumScoreBasedPlayerSelectionCriteria(minimumScoreBasedPlayerSelectionCriteria);
		setMaximumScoreBasedPlayerSelectionCriteria(maximumScoreBasedPlayerSelectionCriteria);
	}

	public RangeScoreBoundPlayerSelectionCriteria(long minimum,
			boolean includeMin, long maximum, boolean includeMax) {
		this(new MinimumScoreBasedPlayerSelectionCriteria(minimum, includeMin),
				new MaximumScoreBasedPlayerSelectionCriteria(maximum,
						includeMax));
	}

	public RangeScoreBoundPlayerSelectionCriteria(long minimum, long maximum) {
		this(minimum, true, maximum, true);
	}

	public MinimumScoreBasedPlayerSelectionCriteria getMinimumScoreBasedPlayerSelectionCriteria() {
		return minimumScoreBasedPlayerSelectionCriteria;
	}

	public void setMinimumScoreBasedPlayerSelectionCriteria(
			MinimumScoreBasedPlayerSelectionCriteria minimumScoreBasedPlayerSelectionCriteria) {
		this.minimumScoreBasedPlayerSelectionCriteria = minimumScoreBasedPlayerSelectionCriteria;
	}

	public MaximumScoreBasedPlayerSelectionCriteria getMaximumScoreBasedPlayerSelectionCriteria() {
		return maximumScoreBasedPlayerSelectionCriteria;
	}

	public void setMaximumScoreBasedPlayerSelectionCriteria(
			MaximumScoreBasedPlayerSelectionCriteria maximumScoreBasedPlayerSelectionCriteria) {
		this.maximumScoreBasedPlayerSelectionCriteria = maximumScoreBasedPlayerSelectionCriteria;
	}

	@Override
	public boolean matches(Player item) {
		boolean result = false;
		if (getMinimumScoreBasedPlayerSelectionCriteria().matches(item)
				&& getMaximumScoreBasedPlayerSelectionCriteria().matches(item)) {
			result = true;
		}
		return result;
	}

}
