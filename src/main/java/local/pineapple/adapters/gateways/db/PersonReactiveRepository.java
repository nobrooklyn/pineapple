package local.pineapple.adapters.gateways.db;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonReactiveRepository extends ReactiveCrudRepository<PersonEntity, String> {
}
