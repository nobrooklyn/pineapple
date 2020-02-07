package local.pineapple.adapters.handlers.persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import local.pineapple.adapters.handlers.persons.add.PersonAddHandler;
import local.pineapple.adapters.handlers.persons.list.PersonListHandler;

@Component
public class PersonHandler {
	private final PersonAddHandler addHandler;
	private final PersonListHandler listHandler;

	@Autowired
	public PersonHandler(PersonAddHandler addHandler, PersonListHandler listHandler) {
		this.addHandler = addHandler;
		this.listHandler = listHandler;
	}

	public RouterFunction<ServerResponse> route() {
		return RouterFunctions.route().path("/persons", builder -> {
			builder.GET("/", listHandler::list) //
					// .GET("/{personId}", this::find) //
					.POST("/", addHandler::add);
		}).build();
	}
}
