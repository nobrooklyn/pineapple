package local.pineapple.global.validators;

import java.util.Optional;

class MaxLengthValidator {
	private static final String TYPE = "maxLength";
	private static final String MESSAGE = "%s length over. max=%d";

	static Optional<ConstraintViolation> validate(String itemName, String itemValue, int maxLength) {
		if (itemValue.length() > maxLength) {
			return Optional.of(new ConstraintViolation(itemName, TYPE, String.format(MESSAGE, itemName, maxLength)));
		}
		return Optional.empty();
	}
}