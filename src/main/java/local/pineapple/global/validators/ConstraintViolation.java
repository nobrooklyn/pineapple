package local.pineapple.global.validators;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
public class ConstraintViolation {
	private final String item;
	private final String type;
	private final String message;

	public static Set<ConstraintViolation> collection() {
		return new HashSet<>();
	}
}