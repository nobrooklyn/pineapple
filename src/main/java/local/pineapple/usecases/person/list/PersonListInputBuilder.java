package local.pineapple.usecases.person.list;

import local.pineapple.usecases.core.UseCaseInputBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(value = AccessLevel.PACKAGE)
@Setter
@Accessors(chain = true, fluent = true)
public class PersonListInputBuilder implements UseCaseInputBuilder<PersonListInput> {
	private String name;

	@Override
	public PersonListInput build() {
		return new PersonListInput(name);
	}

}