package local.pineapple.usecases.core;

public interface UseCaseInputBuilder<Ui extends UseCaseInput> {
	public Ui build();

	default int intVal(String nm) {
		return Integer.decode(nm);
	}
}