package training;

import java.util.ArrayList;
import java.util.List;

public class CalculateStep {

	private List<String> operations;
	private List<Integer> numbers;

	public CalculateStep(List<Integer> numbersParameter, List<String> operationsParameter) {
		setNumbers(numbersParameter);
		setOperations(operationsParameter);
	}

	private void setOperations(List<String> operations) {
		this.operations = new ArrayList<>(operations);
	}

	private void setNumbers(List<Integer> numbers) {
		this.numbers = new ArrayList<>(numbers);
	}

	public int getResult() {
		if (numbers.size() != 1) {
			throw new IllegalStateException("Invalid usage!");
		}
		return numbers.get(0);
	}

	public void calculateStep(Operation... operationsToExecute) {
		int index = 1;
		while (index < operations.size()) {
			boolean processed = calculatePossibleOperations(index, operationsToExecute);
			if (!processed) {
				index++;
			}
		}
	}

	private boolean calculatePossibleOperations(int index, Operation... operationsToExecute) {
		boolean processed = false;
		for (int i = 0; i < operationsToExecute.length && !processed; i++) {
			Operation operation = operationsToExecute[i];
			processed = tryOperation(index, operation);
		}
		return processed;
	}

	private boolean tryOperation(int index, Operation operation) {
		boolean processed = false;
		if (operation.getOperator().equals(operations.get(index))) {
			executeOperation(index, operation);
			processed = true;
		}
		return processed;
	}

	private void executeOperation(int index, Operation operation) {
		int result = operation.calculate(numbers.get(index - 1), numbers.get(index));
		numbers.set(index - 1, result);
		operations.remove(index);
		numbers.remove(index);
	}
}
