package com.doranco.chiffrage;

import java.security.Key;

import javax.crypto.Cipher;

public final class CryptageAlgo {
	private CryptageAlgo() {
	}

	public final static byte[] encrypt(String messageToEncrypt, Key key, String algo) throws Exception {

		Cipher cipher = Cipher.getInstance(algo);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] messageInByte = messageToEncrypt.getBytes("UTF-8");
		byte[] messageEncrypte = cipher.doFinal(messageInByte);
		
		return messageEncrypte;
	}

	public final static String decrypt(byte[] messageToDecrypt, Key key, String algo) throws Exception {
		
		Cipher cipher = Cipher.getInstance(algo);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] messageDecrypte = cipher.doFinal(messageToDecrypt);
		String originalMessage = new String(messageDecrypte, "UTF-8");
		
		return originalMessage;

	}
}
