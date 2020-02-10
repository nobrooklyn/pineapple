package local.pineapple.adapters.handlers.persons.save;

import org.springframework.stereotype.Component;

import local.pineapple.usecases.person.save.PersonSaveInput;
import local.pineapple.usecases.person.save.PersonSaveOutput;

@Component
class PersonSavePresenter {
	PersonSaveInput personSaveInput(PersonSaveRequest req) {
		return PersonSaveInput.builder() //
				.id(req.getId()) //
				.givenName(req.getGivenName()) //
				.familyName(req.getFamilyName()) //
				.birthYear(req.getBirthYear()).birthMonth(req.getBirthMonth()).birthDay(req.getBirthDay()) //
				.sex(req.getSexCode()) //
				.bloodType(req.getBloodType()).build();
	}

	PersonSaveResponse personSaveResponse(PersonSaveOutput output) {
		return new PersonSaveResponse(output.id());
	}

}