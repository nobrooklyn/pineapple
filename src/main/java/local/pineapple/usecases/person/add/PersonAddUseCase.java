package local.pineapple.usecases.person.add;

import local.pineapple.usecases.core.UseCase;
import reactor.core.publisher.Mono;

public interface PersonAddUseCase extends UseCase<Mono<PersonAddInput>, Mono<PersonAddOutput>> {
}