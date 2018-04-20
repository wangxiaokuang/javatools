package tum0r.algorithm;

public class ComplexCalculator {
	private int real;
	private int virtual;

	public ComplexCalculator(int real, int virtual) {
		this.real = real;
		this.virtual = virtual;
	}

	public int getReal() {
		return real;
	}

	public int getVirtual() {
		return virtual;
	}

	public String getResult() {
		return real + (virtual >= 0 ? "+" : "") + virtual + "i";
	}

	public ComplexCalculator add(ComplexCalculator complexCalculator) {
		int real = this.real + complexCalculator.real;
		int virtual = this.virtual + complexCalculator.virtual;
		ComplexCalculator result = new ComplexCalculator(real, virtual);
		return result;
	}

	public ComplexCalculator subtract(ComplexCalculator complexCalculator) {
		int real = this.real - complexCalculator.real;
		int virtual = this.virtual - complexCalculator.virtual;
		ComplexCalculator result = new ComplexCalculator(real, virtual);
		return result;
	}

	// (a+bi)(c+di)=(ac-bd)+(bc+ad)i.
	public ComplexCalculator multiply(ComplexCalculator complexCalculator) {
		int real = this.real * complexCalculator.real - this.virtual * complexCalculator.virtual;
		int virtual = this.virtual * complexCalculator.real + this.real * complexCalculator.virtual;
		ComplexCalculator result = new ComplexCalculator(real, virtual);
		return result;
	}

	// (a+bi)/(c+di)=(ac+bd)/(c^2+d^2) +((bc-ad)/(c^2+d^2))i
	public ComplexCalculator divide(ComplexCalculator complexCalculator) {
		int temp = (int) (Math.pow(complexCalculator.real, 2) + Math.pow(complexCalculator.virtual, 2));
		int real = (this.real * complexCalculator.real + this.virtual * complexCalculator.virtual) / temp;
		int virtual = (this.virtual * complexCalculator.real - this.real * complexCalculator.virtual) / temp;
		ComplexCalculator result = new ComplexCalculator(real, virtual);
		return result;
	}

	/*
	 * (x+yi)^n = r^n * cos(n*A) + i * r^n * sin(nA)
	 * 
	 * r = (x^2 + y^2) ^ (1/2)，A = arctan(y/x)
	 */
	public ComplexCalculator pow(int n) {
		double r = Math.pow(Math.sqrt(Math.pow(real, 2) + Math.pow(virtual, 2)), n);
		double A = Math.atan2(virtual, real) * n;
		int real = (int) ((Math.abs(r * Math.cos(A)) + 0.5) * Math.pow(-1, n - 1));
		int virtual = (int) (r * Math.sin(A) + 0.5);
		ComplexCalculator result = new ComplexCalculator(real, virtual);
		return result;
	}
}
