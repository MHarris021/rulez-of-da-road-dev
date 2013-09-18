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

import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;
import com.darcstarsolutions.games.rulezofdaroad.repositories.mongo.PlayerTemplateRepository;

@Controller
@RequestMapping(value = "/playerTemplates", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerTemplateRestController {

	@Resource
	private PlayerTemplateRepository playerTemplateRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<PlayerTemplate>> getPlayerTemplates() {
		List<PlayerTemplate> playerTemplates = playerTemplateRepository
				.findAll();
		URI location = linkTo(PlayerTemplateRestController.class).toUri();
		ResponseEntity<List<PlayerTemplate>> responseEntity = new ResponseEntity<List<PlayerTemplate>>(
				playerTemplates, HttpStatus.OK);
		responseEntity.getHeaders().setLocation(location);
		return responseEntity;
	}
}
