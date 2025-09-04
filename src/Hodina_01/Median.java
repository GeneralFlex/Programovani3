package Hodina_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Median {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\vincent.klouda.s\\IdeaProjects\\Programovani3\\src\\Hodina_01\\vstup.txt");
        Scanner input = new Scanner(file);
        ArrayList<Integer> list = new ArrayList<>();
        while (input.hasNext()) {
            list.add(input.nextInt());
        }
        boolean sorted=false;
        while(!sorted) {
            sorted=true;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i) > list.get(j)) {
                        int temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                        sorted=false;
                    }
                }
            }
        }

        if(list.size()%2==0) {
            System.out.println(list.get(list.size()/2-1)+", " + list.get(list.size()/2));
        } else {
            System.out.println(list.size()/2+1);
        }
    }
}
