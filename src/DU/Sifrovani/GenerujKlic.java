package DU.Sifrovani;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class GenerujKlic {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();
        File f = new File("./klic.dat");
        f.createNewFile();
        Files.write(Paths.get("./klic.dat"), key.getEncoded());
    }
}
