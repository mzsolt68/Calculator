package training;

public class Division implements Operation {

	@Override
	public String getOperator() {
		return "/";
	}

	@Override
	public int calculate(int left, int right) {
		return left / right;
	}

}
