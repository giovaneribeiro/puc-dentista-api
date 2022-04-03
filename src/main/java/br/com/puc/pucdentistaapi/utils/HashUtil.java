package br.com.puc.pucdentistaapi.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class HashUtil {
  
  public static String hash(String senha) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    byte[] encodedHash = md.digest(senha.getBytes(StandardCharsets.UTF_8));
    return DatatypeConverter.printHexBinary(encodedHash);
  }
}
