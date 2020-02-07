package local.pineapple.global.validators;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConstraintViolationException extends ResponseStatusException {
	private static final long serialVersionUID = 1L;

	private static final String message = "constraint violation.";

	private final Set<ConstraintViolation> violations;

	public ConstraintViolationException() {
		super(HttpStatus.BAD_REQUEST, message);
		this.violations = ConstraintViolation.collection();
	}

	public ConstraintViolationException(Set<ConstraintViolation> violations) {
		super(HttpStatus.BAD_REQUEST, message);
		this.violations = violations;
	}

	public Set<ConstraintViolation> violations() {
		return violations;
	}
}