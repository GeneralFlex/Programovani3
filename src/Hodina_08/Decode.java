package Hodina_08;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Decode {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {

        String klic = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ0aq4p+aR2+t/RLy1ZoE/pPswffo2JsbvtDFhE5RnH/TJXCZgSHMxhB39bIMOn2ElXeEHPcyV9m4LR/Mu35+8MCAwEAAQ==";

        byte[] bytes = Base64.getDecoder().decode(klic);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey key = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal("ahoj".getBytes());

        String out = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println(out);

    }
}
