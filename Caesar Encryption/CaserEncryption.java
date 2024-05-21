
/**
 * encrypt
 */
import java.util.LinkedList;

import java.util.Scanner;

/**
 * Caesar
 */
class Caesar {
    Scanner sc = new Scanner(System.in);
    private int key;

    Caesar() {
        setKey(3);
    }

    Caesar(int key) {
        setKey(key);
    }

    int getKey() {

        if (this.key == 0) {
            this.key = sc.nextInt();

        } else if (this.key == 26) {
            System.out.println("in this algorithum it not allowd zero or 26 as key set key between 0-25");
            this.key = sc.nextInt();

        }

        return this.key;
    }

    void setKey(int temp) {
        this.key = temp;
        // Scanner sc = new Scanner(System.in);
        if (this.key == 0) {
            this.key = sc.nextInt();

        } else if (this.key == 26) {
            System.out.println("in this algorithum it not allowd zero or 26 as key set key between 1-25 or above 26");
            this.key = sc.nextInt();

        }

    }

    String encrypt(String plaintext) {
        int temp;
        String ciphertext = "";
        plaintext = plaintext.trim();
        plaintext = plaintext.toUpperCase();
        int key = getKey();
        for (int i = 0; i < plaintext.length(); i++) {
            if (plaintext.charAt(i) == ' ') {
                ciphertext += plaintext.charAt(i);
            } else {

                temp = ((((int) plaintext.charAt(i) + key) - 65) % 26);
                temp += 65;
                ciphertext += (char) temp;
            }

        }
        return ciphertext;
    }

    String encrypt(int key, String plaintext) {
        int temp;
        String ciphertext = "";
        plaintext = plaintext.trim();
        plaintext = plaintext.toUpperCase();

        for (int i = 0; i < plaintext.length(); i++) {
            if (plaintext.charAt(i) == ' ') {
                ciphertext += plaintext.charAt(i);
            } else {

                temp = ((((int) plaintext.charAt(i) + key) - 65) % 26);
                temp += 65;
                ciphertext += (char) temp;
            }

        }
        return ciphertext;
    }

    String Decrypt(String ciphertext) {
        int temp;
        int key = getKey();
        String plaintext = "";
        ciphertext = ciphertext.trim();
        ciphertext = ciphertext.toUpperCase();

        for (int i = 0; i < ciphertext.length(); i++) {

            if (ciphertext.charAt(i) == ' ') {
                plaintext += ciphertext.charAt(i);
            } else {

                temp = (((int) ciphertext.charAt(i) - key) - 65) % 26;
                if (temp < 0) {
                    temp = 26 + temp;
                    temp += 65;
                } else {
                    temp += 65;
                }
                plaintext += (char) temp;
            }

        }
        return plaintext;
    }

    String Decrypt(int key, String ciphertext) {
        int temp;
        String plaintext = "";
        ciphertext = ciphertext.trim();
        ciphertext = ciphertext.toUpperCase();

        for (int i = 0; i < ciphertext.length(); i++) {

            if (ciphertext.charAt(i) == ' ') {
                plaintext += ciphertext.charAt(i);
            } else {

                temp = (((int) ciphertext.charAt(i) - key) - 65) % 26;
                if (temp < 0) {
                    temp = 26 + temp;
                    temp += 65;
                } else {
                    temp += 65;
                }
                plaintext += (char) temp;
            }

        }
        return plaintext;
    }

    LinkedList<String> BruteForce(String ciphertext) {
        LinkedList<String> plaindata = new LinkedList<String>();
        for (int i = 0; i < 26; i++) {
            plaindata.addLast(Decrypt(i, ciphertext));
        }
        return plaindata;
    }
}

public class CaserEncryption {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Caesar cp = new Caesar();

        boolean Exit = false;
        int choice = 0;
        int temp = 0;
        do {

            System.out.println("[1] caesar Encrypter");
            System.out.println("[2] caesar Decrypter");
            System.out.println("[3] caesar BruteForcer");
            System.out.println("[4] caesar Exit");
            System.out.println("Enter Your choice :");
            choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("enter Encryption Key : ");
                        temp = sc.nextInt();
                        cp.setKey(temp);
                        System.out.println("Key set to => " + temp);
                        System.out.print("Enter your plaintext :=>");
                        String plainstr = sc1.nextLine();
                        System.out.println("Ciphertext : " + cp.encrypt(temp, plainstr));
                        break;
                    case 2:
                        System.out.print("enter Encryption Key : ");
                        temp = sc.nextInt();
                        cp.setKey(temp);
                        System.out.println("Key set to => " + temp);
                        System.out.print("Enter your ciphertext :=>");
                        String cipherstr = sc1.nextLine();
                        System.out.println("plaintext : " + cp.Decrypt(temp, cipherstr));
                        break;
                    case 3:
                        System.out.print("Enter your ciphertext :=>");
                        String Rowstr = sc1.nextLine();
                        LinkedList<String> data = cp.BruteForce(Rowstr);
                        for (String strr : data) {
                            System.out.println("<===========================================================>");
                            System.out.println("| " + strr + " |");
                            System.out.println("<===========================================================>");
                        }
                        break;
                    case 4:
                        System.out.println("thanks");
                        Exit = true;
                        break;
                    default:
                        System.out.println("thanks");
                        Exit = true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Exit = true;
            }
        } while (!Exit);

    }

}