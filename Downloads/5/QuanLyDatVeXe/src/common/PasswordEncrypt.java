package common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypt {
	
	public String md5(String pass) {
		String rs = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(pass.getBytes());
			BigInteger bigInteger = new BigInteger(1, md.digest());
			rs = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return rs;
		
	}

	public static void main(String[] args) {
		

	}

}
