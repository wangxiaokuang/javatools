package tum0r.misc;

public class Regexp {

	public static final String GET_IP = "(25[0-5]|2[0-4][\\d]|1\\d{2}|[1-9]\\d|[1-9])(\\.(25[0-5]|2[0-4][\\d]|1\\d{2}|[1-9]\\d|\\d)){3}";
	public static final String VERIFICATION_IP = "^" + GET_IP + "$";

	public static final String VERIFICATION_LOCAL_ADDRESS = "((\\d+\\.){3}(\\d+))|((\\d+:)+(\\d+)%lo)";

	public static final String GET_EMAIL = "[\\w_]+@(\\w+)(\\.\\w+)+";
	public static final String VERIFICATION_EMAIL = "^" + GET_EMAIL + "$";

	public static final String GET_URL = "((http|https|ftp|file|mailto|tel|sms)://)[\\w-_]+(\\.[\\w-_/]+)+\\?{0,1}([\\w\\.=&%]+)*";
	public static final String VERIFICATION_URL = "^" + GET_URL + "$";

	public static final String GET_ID = "[1-6][\\d]{5}(18|19|20)[\\d]{2}(1(1|2)|0[\\d])([0|1|2][\\d]|3[0|1])[\\d]{3}[\\dxX]";
	public static final String VERIFICATION_ID = "^" + GET_ID + "$";

	public static final String GET_CHINESE = "[\\u0391-\\uFFE5]+";
	public static final String VERIFICATION_CHINESE = "^" + GET_CHINESE + "$";
	
}
