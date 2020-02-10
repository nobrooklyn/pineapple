package local.pineapple.usecases.person.save;

import local.pineapple.usecases.core.UseCaseOutput;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class PersonSaveOutput implements UseCaseOutput {
	private String id;
}