package Soutez.Podsloupnost;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Podsloupnost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String radek = sc.nextLine();
        List<Integer> posloupnost = new ArrayList<>();
        boolean lastIsSpace=true;
        for(char ch : radek.toCharArray()) {
            if(Character.isDigit(ch)&&lastIsSpace) {
                posloupnost.add(Character.getNumericValue(ch));
                lastIsSpace=false;
            }else if(Character.isDigit(ch)&&!lastIsSpace) {
                int lastIndex = posloupnost.size() - 1;
                int newValue = posloupnost.get(lastIndex) * 10 + Character.getNumericValue(ch);
                posloupnost.set(lastIndex, newValue);
            }
            if(ch==' ') lastIsSpace=true; {}
        }
        int nejdelsi=1;
        int curr=1;
        for(int i=0;i<posloupnost.size()-1;i++) {
            if(posloupnost.get(i+1)>posloupnost.get(i)) {
                curr++;
            }else{
                if(nejdelsi<curr){
                    nejdelsi=curr;
                }
                curr=1;
            }
        }
        if(nejdelsi<curr){
            nejdelsi=curr;
        }
        System.out.println(nejdelsi);

    }
}
