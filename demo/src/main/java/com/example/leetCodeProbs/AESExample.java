package com.example.leetCodeProbs;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

public class AESExample {
    public static void main(String[] args) {
        String originalString = "AA";
        String secretKey = "AA"; // Change this key (should be 16, 24, or 32 bytes)

        System.out.println("formatted string--> "+String.format("%10s",originalString));
        try {
//            Key key = generateKey(secretKey);
//            Cipher cipher = Cipher.getInstance("AES");
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            byte[] encryptedBytes = cipher.doFinal(originalString.getBytes());

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            //String base64Encoded = Base64.getEncoder().encodeToString(encryptedBytes);

            String hexEncodedString = bytesToHex(bytes);
            //String encodedString = base64Encoded.replace('+', '-').replace('', '');

            System.out.println("Encoded String without special characters: " + hexEncodedString);

            byte[] decodedBytes = hexToBytes(hexEncodedString);

            String decryptedString = new String(decodedBytes);
            System.out.println("Decrypted String: " + decryptedString);
            // Decryption
            //String decodedString = encodedString.replace('-', '+').replace('_', '/');
//            byte[] decodedBytes = Base64.getDecoder().decode(hexEncodedString);
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
//            String decryptedString = new String(decryptedBytes);
//            System.out.println("Decrypted String: " + decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] hexToBytes(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%X", b));
        }
        return hexString.toString();
    }

    private static Key generateKey(String secretKey) throws NoSuchAlgorithmException {
        // SHA-256 generates a 256-bit (32-byte) key
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = sha.digest(secretKey.getBytes(StandardCharsets.ISO_8859_1));

        // Truncate or pad the key to the required length (16, 24, or 32 bytes)
        int keyLength = 16;
        return new SecretKeySpec(Arrays.copyOf(key, keyLength), "AES");
    }
}
