package Soutez.Palindrom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args) throws IOException {
        List<String> slova = new ArrayList<>();
        List<String> palindromy = new ArrayList<>();
        Scanner sc = new Scanner(new File("input.txt"));

        while (sc.hasNext()) {
            slova.add(sc.next().toLowerCase());
        }
        for(String slovo : slova){
            if(jePalindrom(slovo)){
                palindromy.add(slovo);
            }
        }
        for(int i=0;i<palindromy.size();i++){
            System.out.println(palindromy.get(i)+": "+(i+1));
        }
        System.out.println("Celkem: "+palindromy.size());
        sc.close();
    }

    public static boolean jePalindrom(String slovo){

        for (int i = 0; i < slovo.length() / 2; i++) {
            if (slovo.charAt(slovo.length() - 1 - i) != slovo.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}