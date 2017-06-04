package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
	public static void main(String[] args) throws IOException {
		System.out.println("Kérlek írj be egy mûveletsort!");
		String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int result = new Calculator().calculate(line);
		System.out.println(result);
	}

	public int calculate(String line) {
		List<String> operations = Arrays.asList(line.split("[0-9]+"));
		List<String> numbers = Arrays.asList(line.split("[" + Pattern.quote("+-*/") + "]"));
		List<Integer> numbersConverted = convert(numbers);
		int result = calculate(operations, numbersConverted);
		return result;
	}

	private List<Integer> convert(List<String> numbers) {
		List<Integer> numbersConverted = new ArrayList<>();
		for (int i = 0; i < numbers.size(); i++) {
			numbersConverted.add(Integer.valueOf(numbers.get(i)));
		}
		return numbersConverted;
	}

	private int calculate(List<String> operationsParameter, List<Integer> numbersParameter) {
		CalculateStep calculateStep = new CalculateStep(numbersParameter, operationsParameter);
		calculateStep.calculateStep(new Multiplication(), new Division());
		calculateStep.calculateStep(new Addition(), new Subtraction());
		return calculateStep.getResult();
	}
}
