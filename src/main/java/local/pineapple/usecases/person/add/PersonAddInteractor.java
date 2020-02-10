package local.pineapple.usecases.person.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import local.pineapple.domain.model.person.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class PersonAddInteractor implements PersonAddUseCase {
	private PersonRepository repository;

	@Autowired
	public PersonAddInteractor(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public Mono<PersonAddOutput> handle(Mono<PersonAddInput> input) {
		return input.map(in -> in.person()) //
				.flatMap(p -> repository.save(p)) //
				.map(p -> new PersonAddOutput(p.id().value())) //
				.doOnSuccess(out -> log.info("saved a person. {}", out.id())) //
				.doOnError(e -> log.error("can't save.", e));
	}
}