package local.pineapple.adapters.handlers.persons.list;

import local.pineapple.adapters.handlers.core.HandlerRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
class PersonListRequest implements HandlerRequest {
	private String id;
	private String givenName;
	private String familyName;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String sexCode;
	private String bloodType;
}