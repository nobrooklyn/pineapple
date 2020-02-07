package local.pineapple.adapters.handlers.core;

import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;

import java.util.Set;

import org.springframework.web.reactive.function.server.ServerResponse;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import local.pineapple.global.validators.ConstraintViolation;
import lombok.Getter;
import lombok.ToString;
import reactor.core.publisher.Mono;

@Getter
@ToString
@JsonSerialize
public class InvalidHandlerRequestResponse implements HandlerResponse {
	private final String message;
	private final Set<ConstraintViolation> violations;

	public InvalidHandlerRequestResponse(Set<ConstraintViolation> violations) {
		this.message = "invalid request values.";
		this.violations = violations;
	}

	public Mono<ServerResponse> response() {
		return badRequest().bodyValue(this);
	}

}