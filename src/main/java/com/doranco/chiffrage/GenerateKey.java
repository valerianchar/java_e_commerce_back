package com.doranco.chiffrage;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class GenerateKey {
	private GenerateKey() {
	}

	public final static Key getKey(String algorithm, int keysize) throws Exception {

		KeyGenerator keyGen = null;
		
		switch (algorithm) {
			case "DES": // 56 bits
				if (keysize != 56) {
					throw new IllegalArgumentException("Le keysize doit être de 56 bits !");
				}
				keyGen = KeyGenerator.getInstance(algorithm);
				keyGen.init(keysize);
				break;
			case "Blowfish" :
				if(keysize != 56)
				{
					throw new IllegalArgumentException("Le keysize doit être de 56 bits !");
				}
				keyGen = KeyGenerator.getInstance(algorithm);
				keyGen.init(keysize);
				break;
			case "AES" : // 128, 192, and 256 bits
				
				if(keysize != 128) {
					throw new IllegalArgumentException("L'algorythme doit être AES et la keysize doit être de 56 bits !");
				}
				keyGen = KeyGenerator.getInstance(algorithm);
				keyGen.init(keysize);
			default:
				break;
		}
		SecretKey secretKey = keyGen.generateKey();
		return new SecretKeySpec(secretKey.getEncoded(), algorithm);
	}
	
	public final static KeyPair getKeyPair(String algorithm, int keysize) throws Exception {
		
		KeyPair kp = null;
		switch (algorithm) {
		case "DSA": // 512 to 1024 (inclusive), 2048, or 3072 bits (multiple of 64)
			if (keysize < 512 || keysize > 3072 || keysize % 64 != 0) {
				throw new IllegalArgumentException(
						"Le keysize doit être un multiple de 64, compris entre 512 et 1024 (inclus), 2048 ou 3072 !");
			}
			
			break;
		case "RSA": //
			if (keysize < 1024 || keysize > 4096 || keysize % 256 != 0) {
				throw new IllegalArgumentException(
						"Le keysize doit être un multiple de 256, compris entre 1024 et 4096 (inclus), 2048 ou 3072 !");
			}
		
			break;
		default:
			throw new IllegalArgumentException("cette algo "+ algorithm + "n'est pas prisE en charge");
		}
		KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance(algorithm);
		keyPairGenerator.initialize(keysize,new SecureRandom());
		kp= keyPairGenerator.generateKeyPair();
		return kp;
	
	}
}
