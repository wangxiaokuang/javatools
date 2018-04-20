package tum0r.test;

import tum0r.algorithm.ComplexCalculator;

public class ComplexCalaulatorTest {
	public static void test() {
		ComplexCalculator calculator = new ComplexCalculator(2, 3);
		System.out.println(calculator.getResult());
		System.out.println(calculator.pow(2).getResult());
		ComplexCalculator calculator2 = new ComplexCalculator(3, 4);
		System.out.println(calculator.add(calculator2).getResult());
		System.out.println(calculator.subtract(calculator2).getResult());
		System.out.println(calculator.multiply(calculator).getResult());
	}
}
