package local.pineapple.usecases.person.add;

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
public class PersonAddInputBuilder implements UseCaseInputBuilder<PersonAddInput> {
	private String givenName;
	private String familyName;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String sex;
	private String bloodType;

	@Override
	public PersonAddInput build() {
		var violations = new PersonAddInputValidator().validate(this);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}

		return new PersonAddInput(Person.builder() //
				.givenName(givenName).familyName(familyName) //
				.birthDay(LocalDate.of(intVal(birthYear), intVal(birthMonth), intVal(birthDay))) //
				.sexCode(intVal(sex)) //
				.bloodType(bloodType).buildNew());
	}

}