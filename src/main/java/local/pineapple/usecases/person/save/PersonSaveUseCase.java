package local.pineapple.usecases.person.save;

import local.pineapple.usecases.core.UseCase;
import reactor.core.publisher.Mono;

public interface PersonSaveUseCase extends UseCase<Mono<PersonSaveInput>, Mono<PersonSaveOutput>> {
}