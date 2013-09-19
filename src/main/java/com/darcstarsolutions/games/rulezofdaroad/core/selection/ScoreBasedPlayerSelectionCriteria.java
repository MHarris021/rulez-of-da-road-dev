package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public abstract class ScoreBasedPlayerSelectionCriteria implements
		PlayerSelectionCriteria<Player> {

	private long score;

	private boolean boundIncluded;

	public ScoreBasedPlayerSelectionCriteria(long score) {
		this(score, true);
	}

	public ScoreBasedPlayerSelectionCriteria(long score, boolean includeBound) {
		setScore(score);
		setBoundIncluded(includeBound);
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public boolean isBoundIncluded() {
		return boundIncluded;
	}

	public void setBoundIncluded(boolean includeBound) {
		this.boundIncluded = includeBound;
	}

}
