package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.darcstarsolutions.common.core.builders.Builder;
import com.darcstarsolutions.common.utils.ValidationUtils;
import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;

public abstract class PlayerBuilder<T extends Player, S extends PlayerTemplate, U extends PlayerBuilder<T, S, U>>
		extends Builder<T> {

	@Resource
	private ValidationUtils validationUtils;

	public PlayerBuilder() {

	}

	@SuppressWarnings("unchecked")
	public U createPlayer(@NotNull S playerTemplate, Object... args) {
		T player = initializePlayer(playerTemplate, args);
		if (validationUtils.validate(player)) {
			setEntity(player);
		}
		return (U) this;
	}

	protected abstract T initializePlayer(@NotNull S playerTemplate,
			Object... args);

	@SuppressWarnings("unchecked")
	public U setName(@NotEmpty String name) {
		T player = getEntity();
		player.setName(name);
		if (validationUtils.validate(player)) {
			setEntity(player);
		}
		return (U) this;
	}

	@SuppressWarnings("unchecked")
	public U setScore(@NotNull long score) {
		T player = getEntity();
		player.setScore(score);
		if (validationUtils.validate(player)) {
			setEntity(player);
		}
		return (U) this;
	}

}
