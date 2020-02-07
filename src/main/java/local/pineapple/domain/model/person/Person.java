package local.pineapple.domain.model.person;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class Person {
	private PersonId id;
	private Name name;
	private Birthday birthday;
	private Sex sex;
	private BloodType bloodType;

	public static PersonBuilder builder() {
		return new PersonBuilder();
	}
}