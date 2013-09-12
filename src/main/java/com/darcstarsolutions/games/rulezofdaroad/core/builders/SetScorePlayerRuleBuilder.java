package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.darcstarsolutions.games.rulezofdaroad.core.PlayerRule;
import com.darcstarsolutions.games.rulezofdaroad.core.SetScorePlayerRule;

@Component
@Scope(value = "prototype")
public class SetScorePlayerRuleBuilder extends PlayerRuleBuilder {

	@SuppressWarnings("unchecked")
	@Override
	protected <P extends PlayerRule> P initializeRule(
			@NotEmpty Object... objects) throws ConstraintViolationException {
		PlayerRule playerRule = super.initializeRule(objects);
		SetScorePlayerRule setScorePlayerRule = new SetScorePlayerRule();
		setScorePlayerRule.setName(playerRule.getName());
		setScorePlayerRule.setDescription(playerRule.getDescription());
		setScorePlayerRule.setPoints(playerRule.getPoints());
		return (P) setScorePlayerRule;
	}

}
