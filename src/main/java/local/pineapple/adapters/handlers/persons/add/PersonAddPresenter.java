package local.pineapple.adapters.handlers.persons.add;

import org.springframework.stereotype.Component;

import local.pineapple.usecases.person.add.PersonAddInput;
import local.pineapple.usecases.person.add.PersonAddOutput;

@Component
class PersonAddPresenter {
	PersonAddInput personAddInput(PersonAddRequest req) {
		return PersonAddInput.builder() //
				.id(req.getId()) //
				.givenName(req.getGivenName()) //
				.familyName(req.getFamilyName()) //
				.birthYear(req.getBirthYear()).birthMonth(req.getBirthMonth()).birthDay(req.getBirthDay()) //
				.sex(req.getSexCode()) //
				.bloodType(req.getBloodType()).build();
	}

	PersonAddResponse personAddResponse(PersonAddOutput output) {
		return new PersonAddResponse(output.id());
	}

}