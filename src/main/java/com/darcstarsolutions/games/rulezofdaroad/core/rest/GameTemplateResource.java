package com.darcstarsolutions.games.rulezofdaroad.core.rest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import com.darcstarsolutions.games.rulezofdaroad.core.GameTemplate;

public class GameTemplateResource extends Resource<GameTemplate> {

	public GameTemplateResource(GameTemplate content, Link[] links) {
		super(content, links);
		// TODO Auto-generated constructor stub
	}

}
