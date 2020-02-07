package local.pineapple.usecases.core;

import reactor.core.CorePublisher;

public interface UseCase<Pi extends CorePublisher<? extends UseCaseInput>, Po extends CorePublisher<? extends UseCaseOutput>> {
	Po handle(Pi input);
}