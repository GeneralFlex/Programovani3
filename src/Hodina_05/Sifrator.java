package Hodina_05;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class Sifrator {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidKeyException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text to cipher: ");
        String text = input.nextLine();

        //BufferedReader reader = new BufferedReader(new FileReader("Z:\\Programovani3\\src\\Hodina_05\\klic.txt"));
        //String line = reader.readLine();
        byte[] keybites = Files.readAllBytes(Path.of("Z:\\Programovani3\\src\\Hodina_05\\klic.txt"));

        SecretKey key = new SecretKeySpec(keybites, "DES");

        byte[] messageInBytes = text.getBytes();

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] out = cipher.doFinal(messageInBytes);

        //Files.write(Paths.get("Z:\\Programovani3\\src\\Hodina_05\\sifra.txt"), Base64.getEncoder().encodeToString(out));
        System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(out));

        Cipher cipher2 = Cipher.getInstance("DES");
        cipher2.init(Cipher.DECRYPT_MODE, key);
        byte[] out2 = cipher2.doFinal(out);

        System.out.println("Decrypted message: " + new String(out2));
    }
}
