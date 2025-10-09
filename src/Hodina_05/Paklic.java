package Hodina_05;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Paklic {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey key = keyGenerator.generateKey();
        Files.write(Paths.get("Z:\\Programovani3\\src\\Hodina_05\\klic.txt"), key.getEncoded());
        System.out.println(Base64.getEncoder().encodeToString(key.getEncoded()));
    }
}
