package local.pineapple.drivers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;

import local.pineapple.adapters.handlers.core.InvalidHandlerRequestResponse;
import local.pineapple.global.validators.ConstraintViolationException;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
public class CustomeErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {

	public CustomeErrorWebExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties,
			ApplicationContext applicationContext, ObjectProvider<ViewResolver> viewResolvers,
			ServerProperties serverProperties, ServerCodecConfigurer configurer) {
		super(errorAttributes, resourceProperties, serverProperties.getError(), applicationContext);
		setViewResolvers(viewResolvers.orderedStream().collect(Collectors.toList()));
		setMessageReaders(configurer.getReaders());
		setMessageWriters(configurer.getWriters());
	}

	@Override
	protected Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
		Throwable t = getError(request);
		if (t instanceof ConstraintViolationException) {
			var e = (ConstraintViolationException) t;
			return new InvalidHandlerRequestResponse(e.violations()).response();
		}

		return super.renderErrorResponse(request);
	}
}
