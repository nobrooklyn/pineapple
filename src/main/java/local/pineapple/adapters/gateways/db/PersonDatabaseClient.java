package local.pineapple.adapters.gateways.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import local.pineapple.domain.model.person.Person;
import local.pineapple.domain.model.person.PersonRepository;
import local.pineapple.queries.person.PersonQuery;
import local.pineapple.queries.person.PersonQueryRequest;
import local.pineapple.queries.person.PersonQueryResponse;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class PersonDatabaseClient implements PersonRepository, PersonQuery {

	@Override
	public Person save(Person person) {
		log.info("save a person. {}", person);
		return person;
	}

	@Override
	public List<PersonQueryResponse> find(PersonQueryRequest req) {
		List<PersonQueryResponse> res = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			res.add(PersonQueryResponse.builder()//
					.id("P000" + i) //
					.givenName("dummy") //
					.familyName("dummy") //
					.birthday(LocalDate.of(1980, 1, i)) //
					.sex(1) //
					.bloodType("B+").build());
		}
		log.info(res.size() + " result.");
		return res;
	}

}