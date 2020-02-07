package local.pineapple.global.validators;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Optional;

class DateValidator {
	private static final String TYPE = "date";

	static Optional<ConstraintViolation> validate(String itemName, int year, int month, int dayOfMonth) {
		try {
			LocalDate.of(year, month, dayOfMonth);
		} catch (DateTimeException e) {
			return Optional.of(new ConstraintViolation(itemName, TYPE, e.getMessage()));
		}

		return Optional.empty();
	}
}