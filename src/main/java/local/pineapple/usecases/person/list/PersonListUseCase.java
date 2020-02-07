package local.pineapple.usecases.person.list;

import local.pineapple.usecases.core.UseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonListUseCase extends UseCase<Mono<PersonListInput>, Flux<PersonListOutput>> {
}