package local.pineapple.adapters.handlers.persons;

public interface PersonPresenter {
	default String sexCodeToName(Integer sexCode) {
		if (sexCode == null) {
			return null;
		}

		switch (sexCode) {
		case 0:
			return "Not known";
		case 1:
			return "Male";
		case 2:
			return "Female";
		case 9:
			return "Not applicable";
		default:
			throw new IllegalStateException("unknown code. " + sexCode);
		}
	}
}
