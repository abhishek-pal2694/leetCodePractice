package com.example.leetCodeProbs;

public class HexDecodeExample {
    public static void main(String[] args) {
        String hexEncodedString = "6cf492188970235ad757bf1db5f1efda8ba46e674c95b9876d6e891983c1c73a"; // Example hex string

        // Convert hex string to bytes
        byte[] decodedBytes = hexStringToByteArray(hexEncodedString);

        Thread t1 = new Thread(()->{

        });
        // Convert bytes to string (assuming it was originally a string)
        String decodedString = new String(decodedBytes);

        System.out.println("Decoded String: " + decodedString);
    }

    private static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
