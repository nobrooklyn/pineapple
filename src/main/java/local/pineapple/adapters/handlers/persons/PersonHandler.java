package local.pineapple.adapters.handlers.persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import local.pineapple.adapters.handlers.persons.list.PersonListHandler;
import local.pineapple.adapters.handlers.persons.save.PersonSaveHandler;

@Component
public class PersonHandler {
	private final PersonSaveHandler saveHandler;
	private final PersonListHandler listHandler;

	@Autowired
	public PersonHandler(PersonSaveHandler saveHandler, PersonListHandler listHandler) {
		this.saveHandler = saveHandler;
		this.listHandler = listHandler;
	}

	public RouterFunction<ServerResponse> route() {
		return RouterFunctions.route().path("/persons", builder -> {
			builder.GET("/", listHandler::list) //
					// .GET("/{personId}", this::find) //
					.POST("/", saveHandler::save) //
					.POST("/{id}", saveHandler::save);
		}).build();
	}
}
