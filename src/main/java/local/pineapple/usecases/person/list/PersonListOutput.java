package local.pineapple.usecases.person.list;

import java.time.LocalDate;

import local.pineapple.usecases.core.UseCaseOutput;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
public class PersonListOutput implements UseCaseOutput {
	private String id;
	private String givenName;
	private String familyName;

	private LocalDate birthday;

	private Integer sexCode;

	private String bloodType;
}
