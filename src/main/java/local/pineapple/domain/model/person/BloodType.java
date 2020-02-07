package local.pineapple.domain.model.person;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import local.pineapple.global.validators.ConstraintViolation;
import local.pineapple.global.validators.ConstraintViolationException;

public enum BloodType {
	NO_ANSWER("N/A"), A_PLUS("A+"), A_MINUS("A-"), B_PLUS("B+"), B_MINUS("B-"), O_PLUS("O+"), O_MINUS("O-"),
	AB_PLUS("AB+"), AB_MINUS("AB-");

	private String type;

	private BloodType(final String type) {
		this.type = type;
	}

	public String type() {
		return type;
	}

	@Override
	public String toString() {
		return name() + "(" + type() + ")";
	}

	private static final Map<String, BloodType> typeMap;
	static {
		typeMap = new HashMap<>();
		Stream.of(values()).forEach(v -> typeMap.put(v.type, v));
	}

	public static BloodType of(final String type) {
		var violations = validate(type);
		if (!violations.isEmpty()) {
			throw new IllegalArgumentException(new ConstraintViolationException(violations));
		}
		return typeMap.get(type);
	}

	public static Set<ConstraintViolation> validate(String type) {
		var violations = ConstraintViolation.collection();
		if (!typeMap.containsKey(type)) {
			violations.add(
					new ConstraintViolation("bloodType", "undefined", String.format("%s is undefined value.", type)));
		}
		return violations;
	}
}
