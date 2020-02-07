package local.pineapple.queries.person;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
public class PersonQueryResponse {
	private String id;
	private String givenName;
	private String familyName;

	private LocalDate birthday;

	private Integer sex;
	private String bloodType;
}
