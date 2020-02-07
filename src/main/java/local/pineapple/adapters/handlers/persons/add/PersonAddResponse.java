package local.pineapple.adapters.handlers.persons.add;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Value;

@Value
@JsonSerialize
class PersonAddResponse {
	private final String id;
}