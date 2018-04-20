package tum0r.error;

public class FileTypeException extends Exception {
	private String message;

	public FileTypeException(String message) {
		this.message = message;
	}

	@Override
	public void printStackTrace() {
		System.err.print(message);
		super.printStackTrace();
	}
}
