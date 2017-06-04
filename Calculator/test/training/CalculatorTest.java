package training;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTest {

	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { "5", 5 }, { "1+2", 3 }, { "2*3", 6 }, { "2+3*4", 14 }, { "2+3/4", 2 },
				{ "1+2*3/4", 2 }, { "1*2*3*4*5*6*7*8*9", 362880 } });
	}

	public CalculatorTest(String input, int result) {
		this.input = input;
		this.result = result;
	}

	private String input;
	private int result;
	private Calculator calculator;

	@Test
	public void testCalculate() {
		calculator = new Calculator();
		int calulcatedResult = calculator.calculate(input);
		Assert.assertEquals(result, calulcatedResult);
	}

}
