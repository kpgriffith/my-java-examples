package kpgriffith.examples.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {

  public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {

    UUID id = UUID.randomUUID();
    byte[] clear = id.toString().getBytes("UTF-8");

    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(128);
    SecretKey secretKey = keyGenerator.generateKey();

//    SecretKeySpec skeySpec=new SecretKeySpec(secretKey.getEncoded(),"AES");

    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    byte[] encrypted = cipher.doFinal(clear);

    System.out.println("Encrypted data:");
    for (int i = 0; i < encrypted.length; i++) {
      System.out.print(encrypted[i] + " ");
    }

//    System.out.println(encrypted);

  }
}
