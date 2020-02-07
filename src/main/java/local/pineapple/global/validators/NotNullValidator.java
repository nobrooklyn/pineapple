package local.pineapple.global.validators;

import java.util.Optional;

class NotNullValidator {
	private static final String TYPE = "notNull";
	private static final String MESSAGE = "must not be null.";

	static Optional<ConstraintViolation> validate(String itemName, Object itemValue) {
		if (itemValue == null) {
			return Optional.of(new ConstraintViolation(itemName, TYPE, MESSAGE));
		}

		return Optional.empty();
	}
}