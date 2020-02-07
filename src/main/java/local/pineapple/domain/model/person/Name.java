package local.pineapple.domain.model.person;

import static local.pineapple.global.validators.Validator.isNotBlank;
import static local.pineapple.global.validators.Validator.maxLength;

import java.util.Optional;
import java.util.Set;

import local.pineapple.global.validators.ConstraintViolation;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class Name {
	private final String givenName;
	private final String familyName;

	public Name(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}

	public static Set<ConstraintViolation> validate(String givenName, String familyName) {
		var violations = ConstraintViolation.collection();

		validateGivenName(givenName).ifPresent(v -> violations.add(v));
		validateFamilyName(familyName).ifPresent(v -> violations.add(v));

		return violations;
	}

	private static Optional<ConstraintViolation> validateGivenName(String givenName) {
		return isNotBlank("givenName", givenName).or(() -> maxLength("givenName", givenName, 30));
	}

	private static Optional<ConstraintViolation> validateFamilyName(String familyName) {
		return isNotBlank("familyName", familyName).or(() -> maxLength("familyName", familyName, 30));
	}
}
