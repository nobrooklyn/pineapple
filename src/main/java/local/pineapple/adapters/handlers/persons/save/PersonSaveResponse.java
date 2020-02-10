package local.pineapple.adapters.handlers.persons.save;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Value;

@Value
@JsonSerialize
class PersonSaveResponse {
	private final String id;
}