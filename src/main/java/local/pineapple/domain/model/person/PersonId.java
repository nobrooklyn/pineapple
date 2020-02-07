package local.pineapple.domain.model.person;

import static local.pineapple.global.validators.Validator.isNotBlank;

import java.util.Set;
import java.util.UUID;

import local.pineapple.global.validators.ConstraintViolation;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class PersonId {
	private final String value;

	public static PersonId newId() {
		return new PersonId(UUID.randomUUID().toString());
	}

	public static Set<ConstraintViolation> validate(String id) {
		var violations = ConstraintViolation.collection();

		isNotBlank("personId", id).ifPresent(v -> violations.add(v));

		return violations;
	}

}
