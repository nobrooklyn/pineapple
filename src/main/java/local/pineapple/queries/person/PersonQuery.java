package local.pineapple.queries.person;

import reactor.core.publisher.Flux;

public interface PersonQuery {
	Flux<PersonQueryResponse> find(PersonQueryRequest req);
}