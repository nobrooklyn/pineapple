package local.pineapple.adapters.handlers.persons.save;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import local.pineapple.adapters.handlers.core.HandlerRequest;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonDeserialize
class PersonSaveRequest implements HandlerRequest {
	private String id;
	private String givenName;
	private String familyName;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String sexCode;
	private String bloodType;
}