package local.pineapple.usecases.person.save;

import java.time.LocalDate;

import local.pineapple.domain.model.person.Person;
import local.pineapple.global.validators.ConstraintViolationException;
import local.pineapple.usecases.core.UseCaseInputBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PACKAGE)
@Setter
@Accessors(chain = true, fluent = true)
public class PersonSaveInputBuilder implements UseCaseInputBuilder<PersonSaveInput> {
	private String id;
	private String givenName;
	private String familyName;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String sex;
	private String bloodType;

	@Override
	public PersonSaveInput build() {
		var violations = new PersonSaveInputValidator().validate(this);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}

		return new PersonSaveInput(Person.builder() //
				.id(id) //
				.givenName(givenName).familyName(familyName) //
				.birthDay(LocalDate.of(intVal(birthYear), intVal(birthMonth), intVal(birthDay))) //
				.sexCode(intVal(sex)) //
				.bloodType(bloodType) //
				.buildNewOrExist());
	}

}