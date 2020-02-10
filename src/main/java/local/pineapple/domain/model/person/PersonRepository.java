package local.pineapple.domain.model.person;

import reactor.core.publisher.Mono;

public interface PersonRepository {
	public Mono<Person> save(Person person);
}