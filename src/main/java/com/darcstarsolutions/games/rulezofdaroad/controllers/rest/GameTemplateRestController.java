package com.darcstarsolutions.games.rulezofdaroad.controllers.rest;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.darcstarsolutions.games.rulezofdaroad.core.GameTemplate;
import com.darcstarsolutions.games.rulezofdaroad.repositories.mongo.GameTemplateRepository;

@Controller
@RequestMapping(value = "gametemplates", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameTemplateRestController {

	@Resource
	private GameTemplateRepository gameTemplateRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<GameTemplate>> gameTemplates() {
		List<GameTemplate> gameTemplates = gameTemplateRepository.findAll();
		URI location = linkTo(GameTemplateRestController.class).toUri();
		ResponseEntity<List<GameTemplate>> responseEntity = new ResponseEntity<List<GameTemplate>>(
				gameTemplates, HttpStatus.OK);
		responseEntity.getHeaders().setLocation(location);
		return responseEntity;
	}

}
