package tum0r.error;

public class CountShortException extends Exception {
	String message;

	public CountShortException(String message) {
		this.message = message;
	}

	@Override
	public void printStackTrace() {
		System.err.print(message);
		super.printStackTrace();
	}
}
