package local.pineapple.global.validators;

import java.util.Optional;

public class Validator {
	public static Optional<ConstraintViolation> isNotNull(String itemName, Object itemValue) {
		return NotNullValidator.validate(itemName, itemValue);
	}

	public static Optional<ConstraintViolation> isNotBlank(String itemName, String itemValue) {
		return NotBlankValidator.validate(itemName, itemValue);
	}

	public static Optional<ConstraintViolation> isInteger(String itemName, String itemValue) {
		return IntegerValidator.validate(itemName, itemValue);
	}

	public static Optional<ConstraintViolation> maxLength(String itemName, String itemValue, int maxLength) {
		return MaxLengthValidator.validate(itemName, itemValue, maxLength);
	}

	public static Optional<ConstraintViolation> isValidDate(String itemName, int year, int month, int dayOfMonth) {
		return DateValidator.validate(itemName, year, month, dayOfMonth);
	}
}
