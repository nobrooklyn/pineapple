package local.pineapple.usecases.core;

import java.util.Set;

import local.pineapple.global.validators.ConstraintViolation;

public abstract class UseCaseInputValidator<T extends UseCaseInputBuilder<? extends UseCaseInput>> {
	public Set<ConstraintViolation> validate(T input) {
		var violations = ConstraintViolation.collection();

		validateInternal(input, violations);

		return violations;
	}

	protected abstract void validateInternal(T input, Set<ConstraintViolation> violations);

	protected int intVal(String nm) {
		return Integer.decode(nm);
	}
}