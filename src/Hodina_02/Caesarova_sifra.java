package Hodina_02;

import javax.crypto.Cipher;

public class Caesarova_sifra {
    public static void main(String[] args) {
        String sifra = "surjudprydql";


        int m=0;
        System.out.println(forceSolve(sifra));
        System.out.println(cipher("programovani",3));
    }

    private static String forceSolve(String sifra) {
        String vysledek = "";
        int m;
        for(int i = 1; i<27; i++) {
            for (char ch : sifra.toCharArray()) {
                if(ch-i<'a'){
                    m=26;
                } else {
                    m=0;
                }
                vysledek += (char)(ch - i+m);
            }
            System.out.println(i+": "+vysledek);
            vysledek = "";
        }
        return "";
    }

    public static String cipher(String sifra, int key) {
        String vysledek = "";
        int m;
        for (char ch : sifra.toCharArray()) {
            if(ch+key>'z'){
                m=26;
            } else {
                m=0;
            }
            vysledek += (char)(ch + key-m);
        }
        return vysledek;
    }
}
