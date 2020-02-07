package local.pineapple.global.validators;

import java.util.Optional;

class IntegerValidator {
	private static final String TYPE = "integer";
	private static final String MESSAGE = "%s is not integer.";

	static Optional<ConstraintViolation> validate(String itemName, String itemValue) {
		if (itemValue == null) {
			return Optional.empty();
		}

		try {
			Integer.decode(itemValue);
		} catch (NumberFormatException e) {
			return Optional.of(new ConstraintViolation(itemName, TYPE, String.format(MESSAGE, itemValue)));
		}

		return Optional.empty();
	}
}