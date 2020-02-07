package local.pineapple.usecases.person.list;

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
public class PersonListInput implements UseCaseInput {
	public String name;

	public static PersonListInputBuilder builder() {
		return new PersonListInputBuilder();
	}
}