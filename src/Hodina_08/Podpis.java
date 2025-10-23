package Hodina_08;


//public MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ3eTxeSqkLRXhEs7BO3knMjiGsF2UEuBayfC0ZBJ76lxBpM3qnPz3EWwDa6oQoqy5PLC8by92Ium8Gw099Z64MCAwEAAQ==
//private MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAnd5PF5KqQtFeESzsE7eScyOIawXZQS4FrJ8LRkEnvqXEGkzeqc/PcRbANrqhCirLk8sLxvL3Yi6bwbDT31nrgwIDAQABAkBCuea7Q3okoOL+JnsoQFStxuyPs9qmsqGiW10EFmEKstDSOlj1GNAEPpTDQVI37OURfv2cjf17cTgFAubD4tExAiEA7J7+hv1auz+NBCC59znNCmOYMLDkWaXXJ5fAtdk/5PMCIQCqzC7sbvEoM4dZrCgQy/FqBFBYWQ79d3KKpGQvnN7DMQIhAIHVW+PF8Jr96+pv6pp05MTmkQNmjGWEUeIvqlYdtqlxAiBW/rtj2DpjVKO7TBH4RDjJ3DqkVXBqMD4aWhNhoRBh8QIhANZ80HrGkvHFXDj2fBPSnLk7anJvr4625riMpqh9cKqS

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Podpis {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {

        String priv = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAnd5PF5KqQtFeESzsE7eScyOIawXZQS4FrJ8LRkEnvqXEGkzeqc/PcRbANrqhCirLk8sLxvL3Yi6bwbDT31nrgwIDAQABAkBCuea7Q3okoOL+JnsoQFStxuyPs9qmsqGiW10EFmEKstDSOlj1GNAEPpTDQVI37OURfv2cjf17cTgFAubD4tExAiEA7J7+hv1auz+NBCC59znNCmOYMLDkWaXXJ5fAtdk/5PMCIQCqzC7sbvEoM4dZrCgQy/FqBFBYWQ79d3KKpGQvnN7DMQIhAIHVW+PF8Jr96+pv6pp05MTmkQNmjGWEUeIvqlYdtqlxAiBW/rtj2DpjVKO7TBH4RDjJ3DqkVXBqMD4aWhNhoRBh8QIhANZ80HrGkvHFXDj2fBPSnLk7anJvr4625riMpqh9cKqS";
        String pub = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ3eTxeSqkLRXhEs7BO3knMjiGsF2UEuBayfC0ZBJ76lxBpM3qnPz3EWwDa6oQoqy5PLC8by92Ium8Gw099Z64MCAwEAAQ==";

        byte[] privbytes = Base64.getDecoder().decode(priv);
        byte[] pubbytes = Base64.getDecoder().decode(pub);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privbytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        String msg = "blablablaaaaaaaa";

        Signature signGenerator = Signature.getInstance("SHA256withRSA");
        signGenerator.initSign((PrivateKey) privateKey);
        signGenerator.update(msg.getBytes());
        byte[] sign = signGenerator.sign();

        System.out.println(msg);
        //System.out.println(sign.Base64);
    }
}
