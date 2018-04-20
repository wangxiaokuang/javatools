package tum0r.error;

public class DataBaseTypeException extends Exception {
	String message = null;

	public DataBaseTypeException(String type) {
		message = "database type is error: " + type + " ";
	}

	@Override
	public void printStackTrace() {
		System.err.print(message);
		super.printStackTrace();
	}
}
