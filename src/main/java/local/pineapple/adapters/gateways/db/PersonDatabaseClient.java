package local.pineapple.adapters.gateways.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import local.pineapple.domain.model.person.Person;
import local.pineapple.domain.model.person.PersonRepository;
import local.pineapple.queries.person.PersonQuery;
import local.pineapple.queries.person.PersonQueryRequest;
import local.pineapple.queries.person.PersonQueryResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonDatabaseClient implements PersonRepository, PersonQuery {
	private final PersonReactiveRepository repository;

	@Autowired
	public PersonDatabaseClient(PersonReactiveRepository repository) {
		this.repository = repository;
	}

	@Override
	public Mono<Person> save(Person person) {
		return repository.existsById(personId(person)).map(exists -> personEntity(person, exists))
				.flatMap(entity -> repository.save(entity)).map(entity -> person(entity));
	}

	@Override
	public Flux<PersonQueryResponse> find(PersonQueryRequest req) {
		return repository.findAll().map(e -> personQueryResponse(e));
	}

	private String personId(Person p) {
		return p.id().value();
	}

	private PersonEntity personEntity(Person p, boolean exists) {
		return PersonEntity.builder() //
				.id(p.id().value()) //
				.givenName(p.name().givenName()) //
				.familyName(p.name().familyName()) //
				.birthday(p.birthday().value()) //
				.sex(p.sex().code()) //
				.bloodType(p.bloodType().type()) //
				.exists(exists) //
				.build();
	}

	private Person person(PersonEntity e) {
		return Person.builder() //
				.id(e.getId()) //
				.givenName(e.getGivenName()).familyName(e.getFamilyName()) //
				.birthDay(e.getBirthday()) //
				.sexCode(e.getSex()) //
				.bloodType(e.getBloodType()) //
				.buildExist();
	}

	private PersonQueryResponse personQueryResponse(PersonEntity e) {
		return PersonQueryResponse.builder() //
				.id(e.getId()) //
				.givenName(e.getGivenName()) //
				.familyName(e.getFamilyName()) //
				.birthday(e.getBirthday()) //
				.sex(e.getSex()) //
				.bloodType(e.getBloodType()) //
				.build();
	}
}
