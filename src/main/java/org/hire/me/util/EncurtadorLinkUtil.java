package org.hire.me.util;

import java.util.Random;

public class EncurtadorLinkUtil {
	
	private static final String BASE_URL_SHORT = "http://shortener";

	public static String generateShortUrl(String alias){
		return BASE_URL_SHORT + "/u/" + alias;
	}
	
	public static String generateKey(){
		return generateKey(7,"ABCDEFGHIJKLMNPQRSTUVXZWYabcdefghijkmnpqrstuvxzwy23456789");
	}	
	
	public static String generateKey(int length, String letras) {
		Random random = new Random();
		StringBuilder saida = new StringBuilder();
		for (int i = 0; i < length; i++) {
			saida.append(letras.charAt(random.nextInt(letras.length())));
		}
		return saida.toString();
	}
	
	public static boolean isEmpty(String valor){
		return valor == null || valor.isEmpty();
	}	

}
