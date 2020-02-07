package local.pineapple.domain.model.person;

import static local.pineapple.global.validators.Validator.isNotNull;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import local.pineapple.global.validators.ConstraintViolation;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class Birthday {
	private LocalDate value;

	public static Set<ConstraintViolation> validate(LocalDate value) {
		var violations = ConstraintViolation.collection();

		isNotNull("birthDay", value).ifPresent(v -> violations.add(v));

		return violations;
	}

	public int age(LocalDate when) {
		return Period.between(value, when).getYears();
	}
}
