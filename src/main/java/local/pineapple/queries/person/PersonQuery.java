package local.pineapple.queries.person;

import java.util.List;

public interface PersonQuery {
	List<PersonQueryResponse> find(PersonQueryRequest req);
}