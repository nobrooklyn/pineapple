package local.pineapple.global.validators;

import java.util.Optional;

class NotBlankValidator {
	private static final String TYPE = "notBlank";
	private static final String MESSAGE = "must not be blank.";

	static Optional<ConstraintViolation> validate(String itemName, String itemValue) {
		if (itemValue == null || itemValue.isBlank()) {
			return Optional.of(new ConstraintViolation(itemName, TYPE, MESSAGE));
		}

		return Optional.empty();
	}
}