package local.pineapple.usecases.person.save;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import local.pineapple.domain.model.person.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class PersonSaveInteractor implements PersonSaveUseCase {
	private PersonRepository repository;

	@Autowired
	public PersonSaveInteractor(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public Mono<PersonSaveOutput> handle(Mono<PersonSaveInput> input) {
		return input.map(in -> in.person()) //
				.flatMap(p -> repository.save(p)) //
				.map(p -> new PersonSaveOutput(p.id().value())) //
				.doOnSuccess(out -> log.info("saved a person. {}", out.id())) //
				.doOnError(e -> log.error("can't save.", e));
	}
}