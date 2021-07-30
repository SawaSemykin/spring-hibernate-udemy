package com.luv2code.springdemo.config;

import com.luv2code.springdemo.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:my-logger.properties")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
										 @Value("${printed.logger.level}") String printedLoggerLevel) {
		return new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);
	}

	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService(){
		return new SadFortuneService();
	}	
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
