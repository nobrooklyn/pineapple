package local.pineapple.usecases.person.add;

import local.pineapple.domain.model.person.Person;
import local.pineapple.usecases.core.UseCaseInput;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PACKAGE)
@ToString
@EqualsAndHashCode
@Accessors(fluent = true)
public class PersonAddInput implements UseCaseInput {
	private final Person person;

	public static PersonAddInputBuilder builder() {
		return new PersonAddInputBuilder();
	}
}