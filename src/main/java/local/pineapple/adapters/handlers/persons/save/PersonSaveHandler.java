package local.pineapple.adapters.handlers.persons.save;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import local.pineapple.usecases.person.save.PersonSaveUseCase;
import reactor.core.publisher.Mono;

@Component
public class PersonSaveHandler {
	private final PersonSaveUseCase useCase;;

	private final PersonSavePresenter presenter;

	@Autowired
	PersonSaveHandler(PersonSaveUseCase useCase, PersonSavePresenter presenter) {
		this.useCase = useCase;
		this.presenter = presenter;
	}

	public Mono<ServerResponse> save(final ServerRequest req) {
		Mono<PersonSaveResponse> res = req.bodyToMono(PersonSaveRequest.class) //
				.map(r -> personId(req) == null ? r : r.setId(personId(req))) //
				.map(r -> presenter.personSaveInput(r)) //
				.flatMap(in -> useCase.handle(Mono.just(in))) //
				.map(out -> presenter.personSaveResponse(out));

		return ok().body(res, PersonSaveResponse.class);
	}

	private String personId(ServerRequest req) {
		return req.pathVariables().get("id");
	}
}
