package local.pineapple.drivers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import local.pineapple.adapters.handlers.persons.PersonHandler;

@Configuration
public class RouterConfiguration {
	@Bean
	public RouterFunction<ServerResponse> routes(PersonHandler personHandler) {
		return personHandler.route();
	}
}