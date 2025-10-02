package Hodina_05;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        BigInteger sol = new BigInteger("1");
        for(int i=25;i>0;i--){
            sol = sol.multiply(BigInteger.valueOf(i));
        }
        System.out.println(sol);
    }
}
