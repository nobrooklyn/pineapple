package local.pineapple.domain.model.person;

import java.time.LocalDate;
import java.util.Set;

import local.pineapple.global.validators.ConstraintViolation;
import local.pineapple.global.validators.ConstraintViolationException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Accessors(chain = true, fluent = true)
public class PersonBuilder {
	private String id;
	private String givenName;
	private String familyName;
	private LocalDate birthDay;
	private int sexCode;
	private String bloodType;

	public Person buildNewOrExist() {
		return id == null ? buildNew() : buildExist();
	}

	public Person buildNew() {

		var violations = validateAttributes();
		if (!violations.isEmpty()) {
			throw new IllegalArgumentException(new ConstraintViolationException(violations));
		}

		return new Person(PersonId.newId(), //
				new Name(givenName, familyName), //
				new Birthday(birthDay), //
				Sex.of(this.sexCode), //
				BloodType.of(this.bloodType));
	}

	public Person buildExist() {

		var violations = validateId();
		violations.addAll(validateAttributes());
		if (!violations.isEmpty()) {
			throw new IllegalStateException(new ConstraintViolationException(violations));
		}

		return new Person(new PersonId(id), //
				new Name(givenName, familyName), //
				new Birthday(birthDay), //
				Sex.of(this.sexCode), //
				BloodType.of(this.bloodType));
	}

	private Set<ConstraintViolation> validateId() {
		var violations = ConstraintViolation.collection();

		violations.addAll(PersonId.validate(id));

		return violations;
	}

	private Set<ConstraintViolation> validateAttributes() {
		var violations = ConstraintViolation.collection();

		violations.addAll(Name.validate(givenName, familyName));
		violations.addAll(Birthday.validate(birthDay));
		violations.addAll(Sex.validate(sexCode));
		violations.addAll(BloodType.validate(bloodType));

		return violations;
	}

}