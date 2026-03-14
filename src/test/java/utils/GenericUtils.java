package utils;

import java.util.UUID;
public class GenericUtils {
	public String generateMail() {
		return "testuser" + UUID.randomUUID().toString().substring(0, 6)
				+ "@gmail.com";
	}
	
	public String generatePassword() {
		return UUID.randomUUID().toString().substring(0, 9);
	}
}
