package Hodina_01;

import java.util.Scanner;

public class CifernySoucet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int soucet=0;

        while(input>0){
            soucet+=input%10;
            input/=10;
        }
        System.out.println(soucet);
        sc.close();
    }
}
