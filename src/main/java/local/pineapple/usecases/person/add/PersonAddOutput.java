package local.pineapple.usecases.person.add;

import local.pineapple.usecases.core.UseCaseOutput;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class PersonAddOutput implements UseCaseOutput {
	private String id;
}