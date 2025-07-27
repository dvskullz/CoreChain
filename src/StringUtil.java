/**
 * StringUtil.java
 *
 * Utility class providing helper methods for cryptographic functions.
 * Includes SHA-256 hashing and string generation for mining difficulty.
 *
 * Methods:
 * - applySha256(String input)
 * - getDifficultyString(int difficulty)
 *
 * Author: [dvskullz]
 */

import java.security.MessageDigest;

public class StringUtil {
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha256 to our input,
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
