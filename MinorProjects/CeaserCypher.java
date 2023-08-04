package Projects;

import java.util.Random;
import java.util.Scanner;

public class CeaserCipher {
    private char[] encoder,decoder;
    private int key;
    private char ch = 32;
    Random r;

    public CeaserCipher(){
        encoder = new char[127-32];
        decoder = new char[127-32];
        r = new Random();
        key = r.nextInt(95) + 1;

        for(int i = 0; i < 95; i++){
            encoder[i] = (char) (ch + (i + key) % 95);
            decoder[i] = (char) (ch + (i - key + 95 )% 95);
        }
    }
    
    public int getKey() {
    	return key;
    }

    public String encrypt(String s){
        char[] ar = s.toCharArray();
        for(int i = 0;i<ar.length;i++){
            int j = ar[i] - ch;
            ar[i] = encoder[j];
        }
        return new String(ar);
    }

    public String decrypt(String s){
        char[] ar = s.toCharArray();
        for(int i = 0;i<ar.length;i++){
            int j = ar[i] - ch;
            ar[i] = decoder[j];
        }
        return new String(ar);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String to encode: ");
        String msg = sc.nextLine();
        CeaserCipher c = new CeaserCipher();
        String encoded = c.encrypt(msg);
        System.out.println("Encrypted message: "+encoded);
        System.out.println("Decrypted message: "+c.decrypt(encoded));
        System.out.println("Key: "+c.getKey());
    }

}
