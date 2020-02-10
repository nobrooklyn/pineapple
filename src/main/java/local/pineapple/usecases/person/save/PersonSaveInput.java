package local.pineapple.usecases.person.save;

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
public class PersonSaveInput implements UseCaseInput {
	private final Person person;

	public static PersonSaveInputBuilder builder() {
		return new PersonSaveInputBuilder();
	}
}