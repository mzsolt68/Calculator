package training;

public class Subtraction implements Operation {

	@Override
	public String getOperator() {
		return "-";
	}

	@Override
	public int calculate(int left, int right) {
		return left - right;
	}

}
