package DU.Sifrovani;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Desifruj {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidKeyException {

        byte[] keybites = Files.readAllBytes(Path.of("./klic.dat"));

        SecretKey key = new SecretKeySpec(keybites, "AES");

        byte[] out = Files.readAllBytes(Path.of("message.dat"));

        Cipher cipher2 = Cipher.getInstance("AES");
        cipher2.init(Cipher.DECRYPT_MODE, key);
        byte[] out2 = cipher2.doFinal(out);

        System.out.println(new String(out2));
    }
}
