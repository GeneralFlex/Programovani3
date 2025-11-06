package Hodina_09;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class Certifikat {
    public static void main(String[] args) throws IOException, CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        URL destinationURL = new URL("https://www.google.com");
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();
        for (Certificate cert : certs) {
            System.out.println(cert);
            System.out.println(cert.getPublicKey().toString());
            PublicKey publicKey = cert.getPublicKey();
            try{
                cert.verify(publicKey);
                System.out.println("platny");
            } catch (Exception ignored){
                System.out.println("neplatny");
            }
            System.out.println("-----------------------------------------------------------------");
        }
    }
}
