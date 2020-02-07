package local.pineapple.adapters.handlers.persons.list;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import local.pineapple.usecases.person.list.PersonListUseCase;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class PersonListHandler {
	private final PersonListUseCase useCase;;
	private final PersonListPresenter presenter;

	@Autowired
	PersonListHandler(PersonListUseCase useCase, PersonListPresenter presenter) {
		this.useCase = useCase;
		this.presenter = presenter;
	}

	public Mono<ServerResponse> list(final ServerRequest req) {
		Flux<PersonListResponse> res = Mono.just(presenter.request(req.queryParams())) //
				.map(r -> presenter.input(r)) //
				.flatMapMany(in -> {
					log.info("map {}", in.toString());
					return useCase.handle(Mono.just(in));
				}) //
				.map(out -> presenter.response(out));

		return ok().body(res, PersonListResponse.class);
	}
}
