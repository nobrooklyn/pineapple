package local.pineapple.usecases.person.list;

import org.springframework.stereotype.Component;

import local.pineapple.queries.person.PersonQuery;
import local.pineapple.queries.person.PersonQueryRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonListInteractor implements PersonListUseCase {
	private PersonQuery query;

	public PersonListInteractor(PersonQuery query) {
		this.query = query;
	}

	@Override
	public Flux<PersonListOutput> handle(Mono<PersonListInput> input) {
		PersonQueryRequest req = new PersonQueryRequest();

		return query.find(req).map(res -> PersonListOutput.builder()//
				.id(res.id()) //
				.givenName(res.givenName()) //
				.familyName(res.familyName()) //
				.birthday(res.birthday()) //
				.sexCode(res.sex()) //
				.bloodType(res.bloodType()) //
				.build());
	}
}
