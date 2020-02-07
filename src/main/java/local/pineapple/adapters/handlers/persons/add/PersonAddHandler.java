package local.pineapple.adapters.handlers.persons.add;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import local.pineapple.usecases.person.add.PersonAddUseCase;
import reactor.core.publisher.Mono;

@Component
public class PersonAddHandler {
	private final PersonAddUseCase useCase;;

	private final PersonAddPresenter presenter;

	@Autowired
	PersonAddHandler(PersonAddUseCase useCase, PersonAddPresenter presenter) {
		this.useCase = useCase;
		this.presenter = presenter;
	}

	public Mono<ServerResponse> add(final ServerRequest req) {
		Mono<PersonAddResponse> res = req.bodyToMono(PersonAddRequest.class) //
				.map(r -> presenter.personAddInput(r)) //
				.flatMap(in -> useCase.handle(Mono.just(in))) //
				.map(out -> presenter.personAddResponse(out));

		return ok().body(res, PersonAddResponse.class);
	}
}
