package local.pineapple.usecases.person.add;

import static local.pineapple.global.validators.Validator.isInteger;
import static local.pineapple.global.validators.Validator.isNotBlank;
import static local.pineapple.global.validators.Validator.isValidDate;

import java.util.Optional;
import java.util.Set;

import local.pineapple.domain.model.person.BloodType;
import local.pineapple.domain.model.person.Name;
import local.pineapple.domain.model.person.Sex;
import local.pineapple.global.validators.ConstraintViolation;
import local.pineapple.usecases.core.UseCaseInputValidator;

class PersonAddInputValidator extends UseCaseInputValidator<PersonAddInputBuilder> {

	@Override
	protected void validateInternal(PersonAddInputBuilder input, Set<ConstraintViolation> violations) {
		violations.addAll(Name.validate(input.givenName(), input.familyName()));

		var birthYearResult = validateBirthX("birthYear", input.birthYear());
		var birthMonthResult = validateBirthX("birthMonth", input.birthMonth());
		var birthDayResult = validateBirthX("birthDay", input.birthDay());

		if (birthYearResult.isPresent() || birthMonthResult.isPresent() || birthDayResult.isPresent()) {
			birthYearResult.ifPresent(v -> violations.add(v));
			birthMonthResult.ifPresent(v -> violations.add(v));
			birthDayResult.ifPresent(v -> violations.add(v));
		} else {
			isValidDate("birthYear-birthMonth-birthDay", intVal(input.birthYear()), intVal(input.birthMonth()),
					intVal(input.birthDay())).ifPresent(v -> violations.add(v));
		}

		validateSex("sex", input.sex()).ifPresentOrElse(v -> violations.add(v),
				() -> violations.addAll(Sex.validate(intVal(input.sex()))));

		isNotBlank("bloodType", input.bloodType()).ifPresentOrElse(v -> violations.add(v),
				() -> violations.addAll(BloodType.validate(input.bloodType())));
	}

	private Optional<ConstraintViolation> validateBirthX(String itemName, String itemValue) {
		return isNotBlank(itemName, itemValue).or(() -> isInteger(itemName, itemValue));
	}

	private Optional<ConstraintViolation> validateSex(String itemName, String itemValue) {
		return isNotBlank(itemName, itemValue).or(() -> isInteger(itemName, itemValue));
	}
}