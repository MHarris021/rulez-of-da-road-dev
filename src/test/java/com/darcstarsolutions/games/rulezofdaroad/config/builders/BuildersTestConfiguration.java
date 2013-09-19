package com.darcstarsolutions.games.rulezofdaroad.config.builders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.darcstarsolutions.games.rulezofdaroad.config.utils.UtilsConfig;
import com.darcstarsolutions.games.rulezofdaroad.core.GameTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerRule;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;
import com.darcstarsolutions.games.rulezofdaroad.core.SetScorePlayerRule;
import com.darcstarsolutions.games.rulezofdaroad.core.builders.PlayerRuleBuilder;
import com.darcstarsolutions.games.rulezofdaroad.core.builders.SetScorePlayerRuleBuilder;
import com.darcstarsolutions.games.rulezofdaroad.core.builders.StandardGameTemplateBuilder;
import com.darcstarsolutions.games.rulezofdaroad.core.builders.StandardPlayerBuilder;
import com.darcstarsolutions.games.rulezofdaroad.core.builders.StandardPlayerTemplateBuilder;

@Configuration
@Import(value = { UtilsConfig.class, BuildersConfig.class })
public class BuildersTestConfiguration implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Bean(name = "animals")
	public PlayerRule animals() {
		PlayerRuleBuilder playerRuleBuilder = (PlayerRuleBuilder) applicationContext
				.getBean("playerRuleBuilder");
		playerRuleBuilder.createRule("Animals", "Animals give 1 point", 1);
		PlayerRule playerRule = playerRuleBuilder.build();
		return playerRule;
	}

	@Bean(name = "restaurants")
	public PlayerRule restaurants() {
		PlayerRuleBuilder playerRuleBuilder = (PlayerRuleBuilder) applicationContext
				.getBean("playerRuleBuilder");
		playerRuleBuilder.createRule("Restaurants", "Restaurants give 5 point",
				5);
		PlayerRule playerRule = playerRuleBuilder.build();
		return playerRule;
	}

	@Bean(name = "fog")
	public PlayerRule fog() {
		PlayerRuleBuilder playerRuleBuilder = (PlayerRuleBuilder) applicationContext
				.getBean("playerRuleBuilder");
		playerRuleBuilder.createRule("Fog")
				.setDescription("Fog removes 1 point").setPoints(-1);
		PlayerRule playerRule = playerRuleBuilder.build();
		return playerRule;
	}

	@Bean(name = "cemeteries")
	public SetScorePlayerRule cemeteries() {
		SetScorePlayerRuleBuilder setScorePlayerRuleBuilder = (SetScorePlayerRuleBuilder) applicationContext
				.getBean("setScorePlayerRuleBuilder");
		setScorePlayerRuleBuilder.createRule("Cemeteries")
				.setDescription("Cemetries set points to 0").setPoints(0L);
		SetScorePlayerRule setScorePlayerRule = setScorePlayerRuleBuilder
				.build();
		return setScorePlayerRule;
	}

	@Bean(name = "defaultPlayerRules")
	@Scope(value = "prototype")
	public List<Rule<Player>> defaultPlayerRules() {
		List<Rule<Player>> rules = new ArrayList<Rule<Player>>();
		rules.add(animals());
		rules.add(restaurants());
		rules.add(cemeteries());
		return rules;
	}

	@Bean(name = "defaultPlayerTemplate")
	@Scope(value = "prototype")
	public PlayerTemplate defaultPlayerTemplate() {
		StandardPlayerTemplateBuilder playerTemplateBuilder = applicationContext
				.getBean(StandardPlayerTemplateBuilder.class);
		playerTemplateBuilder.createPlayerTemplate(defaultPlayerRules())
				.setDescription("Default Player Template");
		PlayerTemplate playerTemplate = playerTemplateBuilder.build();
		return playerTemplate;
	}

	@Bean(name = "defaultPlayerTemplates")
	@Scope(value = "prototype")
	public List<PlayerTemplate> defaultPlayerTemplates() {
		List<PlayerTemplate> playerTemplates = new ArrayList<PlayerTemplate>();
		playerTemplates.add(defaultPlayerTemplate());
		playerTemplates.add(defaultPlayerTemplate());
		return playerTemplates;
	}

	@Bean(name = "defaultGameTemplate")
	@Scope(value = "prototype")
	public GameTemplate defaultGameTemplate() {
		StandardGameTemplateBuilder gameTemplateBuilder = (StandardGameTemplateBuilder) applicationContext
				.getBean("standardGameTemplateBuilder");
		gameTemplateBuilder.createGameTemplate(defaultPlayerTemplates());
		GameTemplate gameTemplate = gameTemplateBuilder.build();
		return gameTemplate;
	}

	@Bean(name = "defaultPlayer")
	@Scope(value = "prototype")
	public Player defaultPlayer() {
		StandardPlayerBuilder playerBuilder = (StandardPlayerBuilder) applicationContext
				.getBean("standardPlayerBuilder");
		playerBuilder.createPlayer(defaultPlayerTemplate());
		Player player = playerBuilder.build();
		return player;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}

}
