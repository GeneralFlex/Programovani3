package Hodina_02;

public class Caesarova_sifra {
    public static void main(String[] args) {
        String sifra = "surjudprydql";
        String vysledek = "";

        int m=0;

        for(int i=1;i<27;i++) {
            System.out.println(i+":");
            for (char ch : sifra.toCharArray()) {
                if(ch+i>'z'){
                    m=26;
                } else {
                    m=0;
                }
                vysledek += (char)(ch + i-m);
            }
            System.out.println(vysledek);
            vysledek = "";
        }
    }
}
