
/**
 * MonoalphabeticEncryption
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Monoalphabetic
 */
class Monoalphabetic {

    private String key;

    protected String rendomkeygenarate() {
        Character[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        List<Character> intList = Arrays.asList(arr);
        Collections.shuffle(intList);
        intList.toArray(arr);
        String tempkey = "";
        for (Character character : intList) {
            tempkey += character;
        }
        key = tempkey;
        System.out.println("key : " + tempkey);
        return tempkey;
    }

    protected String getKey() {
        if (!key.isEmpty()) {
            return key;
        } else {
            return rendomkeygenarate();
        }
    }

    protected String Encrypt(String plaintext) {
        // plaintext=hellow world
        plaintext = plaintext.toUpperCase();
        String ciphertext = "";
        String str = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

        String key = getKey().toUpperCase();
        for (int i = 0; i < plaintext.length(); i++) {
            if (plaintext.charAt(i) == ' ') {
                ciphertext += plaintext.charAt(i);
            } else {

                ciphertext += (key.charAt(str.indexOf(plaintext.charAt(i))));
            }
        }

        return ciphertext;
    }

    protected String Decrypt(String key, String ciphertext) {
        // plaintext=hellow world
        ciphertext = ciphertext.toUpperCase();
        System.out.println("key : " + key);
        System.out.println("ciphertext : " + ciphertext);
        key = key.toUpperCase();
        String plaintext = "";
        String str = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

        for (int i = 0; i < ciphertext.length(); i++) {
            if (ciphertext.charAt(i) == ' ') {
                plaintext += ciphertext.charAt(i);
            } else {

                plaintext += str.charAt(key.indexOf(ciphertext.charAt(i)));
            }

        }
        return plaintext;
    }

}

public class MonoalphabeticEncryption {

    public static void main(String[] args) {

        Monoalphabetic mf = new Monoalphabetic();
        mf.rendomkeygenarate();
        System.out.println("Ciphertext : " + mf.Encrypt("hello"));
        System.out.println("plaintext : " + mf.Decrypt("rsipfcgyulwzneqtohmjabdxvk", "YFZZQ"));

    }
}