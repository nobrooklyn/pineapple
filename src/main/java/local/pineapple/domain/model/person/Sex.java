package local.pineapple.domain.model.person;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import local.pineapple.global.validators.ConstraintViolation;
import local.pineapple.global.validators.ConstraintViolationException;

public enum Sex {
	NOT_KNOWN(0), MALE(1), FEMALE(2), NOT_APPLICABLE(9);

	private final int code;

	private Sex(final int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

	@Override
	public String toString() {
		return name() + "(" + code() + ")";
	}

	private static final Map<Integer, Sex> codeMap;
	static {
		codeMap = new HashMap<>();
		Stream.of(values()).forEach(v -> codeMap.put(v.code, v));
	}

	public static Sex of(final int code) {
		var violations = validate(code);
		if (!violations.isEmpty()) {
			throw new IllegalArgumentException(new ConstraintViolationException(violations));
		}
		return codeMap.get(code);
	}

	public static Set<ConstraintViolation> validate(final int code) {
		var violations = ConstraintViolation.collection();
		if (!codeMap.containsKey(code)) {
			violations.add(new ConstraintViolation("sex", "undefined",
					String.format("%d is undefined value.(defined values are %s)", codeMap.keySet())));
		}
		return violations;
	}
}
