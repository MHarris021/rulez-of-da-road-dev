package com.darcstarsolutions.games.rulezofdaroad.config.builders;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.darcstarsolutions.users.core.builders",
		"com.darcstarsolutions.games.rulezofdaroad.core.builders" })
public class BuildersConfig {

}
