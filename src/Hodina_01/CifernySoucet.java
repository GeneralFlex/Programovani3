package Hodina_01;

import java.util.Scanner;

public class CifernySoucet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        //2025
        int soucet=0;

        for(int a=0;a<input;a++){
            soucet+=input%10*a;
        }

        System.out.println(soucet);
    }
}
