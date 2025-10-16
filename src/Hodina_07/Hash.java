package Hodina_07;

import java.util.Scanner;

public class Hash {
    public static void main(String[] args) {
        //Scanner scanner =  new Scanner(System.in);
        //String in = scanner.nextLine();
        //System.out.println(hash(in));
        for(char a='a'; a<'z'; a++){
            for(char b='a'; b<'z'; b++) {
                for (char c='a'; c < 'z'; c++) {
                    //for (char d='a'; d < 'z'; d++) {
                        //for (char e='a'; e < 'z'; e++) {
                            //String str = String.valueOf((char) a) + String.valueOf((char) b) +  String.valueOf((char) c) +  String.valueOf((char) d) +   String.valueOf((char) e);
                            String str = String.valueOf((char) a) + String.valueOf((char) b) +  String.valueOf((char) c);
                            if (hash(str) == 221) {
                                System.out.println(str+": "+hash(str));
                            }
                        //}
                    //}
                }
            }
        }

        //System.out.println(hash("ppppb"));
        //System.out.println(hash("pppea"));
    }

    private static int hash(String in) {
        int sum = 0;
        for (char ch : in.toCharArray()) {
            sum += ch;
            sum =((sum*sum)+3)%1013;
        }

        return sum;
    }
}
