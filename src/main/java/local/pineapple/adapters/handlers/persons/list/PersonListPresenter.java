package local.pineapple.adapters.handlers.persons.list;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import local.pineapple.adapters.handlers.persons.PersonPresenter;
import local.pineapple.usecases.person.list.PersonListInput;
import local.pineapple.usecases.person.list.PersonListOutput;

@Component
class PersonListPresenter implements PersonPresenter {
	PersonListRequest request(MultiValueMap<String, String> query) {
		return PersonListRequest.builder().id(query.getFirst("id")).givenName(query.getFirst("givenName"))
				.familyName(query.getFirst("familyName")).birthYear(query.getFirst("birthYear"))
				.birthMonth(query.getFirst("birthMonth")).birthDay(query.getFirst("birthDay"))
				.sexCode(query.getFirst("sexCode")).bloodType(query.getFirst("bloodType")).build();
	}

	PersonListInput input(PersonListRequest req) {
		return PersonListInput.builder().name(req.getGivenName()).build();
	}

	PersonListResponse response(PersonListOutput output) {
		return PersonListResponse.builder().id(output.id()).name(output.familyName() + " " + output.givenName())
				.birthday(output.birthday().format(DateTimeFormatter.ISO_LOCAL_DATE)).sexCode(output.sexCode())
				.sex(sexCodeToName(output.sexCode())).bloodType(output.bloodType()).build();
	}
}
