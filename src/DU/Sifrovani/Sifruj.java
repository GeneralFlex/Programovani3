package DU.Sifrovani;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Sifruj {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidKeyException {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        byte[] keybites = Files.readAllBytes(Path.of("./klic.dat"));

        SecretKey key = new SecretKeySpec(keybites, "AES");

        byte[] messageInBytes = text.getBytes();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] out = cipher.doFinal(messageInBytes);

        File f = new File("./message.dat");
        f.createNewFile();
        Files.write(Path.of("message.dat"), out);
    }
}
