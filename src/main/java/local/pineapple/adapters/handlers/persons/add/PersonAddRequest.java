package local.pineapple.adapters.handlers.persons.add;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import local.pineapple.adapters.handlers.core.HandlerRequest;
import lombok.Data;

@Data
@JsonDeserialize
class PersonAddRequest implements HandlerRequest {
	private String givenName;
	private String familyName;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String sexCode;
	private String bloodType;
}