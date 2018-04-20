package tum0r.error;

public class PermutationStepException extends Exception {
	private static String message;
	public PermutationStepException(String message) {
		this.message = "step is error:"+message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.print(message);
		super.printStackTrace();
	}
}
