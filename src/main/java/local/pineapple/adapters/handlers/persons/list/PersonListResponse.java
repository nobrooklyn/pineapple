package local.pineapple.adapters.handlers.persons.list;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonSerialize
class PersonListResponse {
	private String id;
	private String name;
	private String birthday;
	private Integer sexCode;
	private String sex;
	private String bloodType;
}
