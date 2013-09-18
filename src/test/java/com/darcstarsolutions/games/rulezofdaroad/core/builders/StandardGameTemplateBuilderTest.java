package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.config.builders.BuildersTestConfiguration;
import com.darcstarsolutions.games.rulezofdaroad.core.GameTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BuildersTestConfiguration.class)
public class StandardGameTemplateBuilderTest {

	@Resource
	private StandardGameTemplateBuilder standardGameTemplateBuilder;

	@Autowired
	private List<PlayerTemplate> playerTemplates;

	@Test
	public void test() {
		assertNotNull(standardGameTemplateBuilder);
	}

	@Test
	public void testCreateGameTemplate() {
		assertNotNull(standardGameTemplateBuilder);
		standardGameTemplateBuilder.createGameTemplate(playerTemplates);
		GameTemplate gameTemplate = standardGameTemplateBuilder.build();
		assertNotNull(gameTemplate);
		assertEquals(playerTemplates.get(0).getDescription(), gameTemplate
				.getPlayerTemplates().get(0).getDescription());
	}

}
