package tum0r.error;

public class ConvertException extends Exception {
	private String message;

	public ConvertException(String message) {
		this.message = message;
	}

	@Override
	public void printStackTrace() {
		System.err.print(message);
		super.printStackTrace();
	}
}
