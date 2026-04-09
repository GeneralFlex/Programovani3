package Hodina_20;

import java.util.ArrayList;
import java.util.Scanner;

public class Heap {

    static int[] heap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        while(n!=0){
            list.add(n);
            n = sc.nextInt();
        }
        System.out.println("pocet cisel: "+list.size());
        System.out.println("Potreba pater: "+(int)(((Math.log(list.size()))/Math.log(2))+1));

        int noveCislo = sc.nextInt();
        list.add(noveCislo);

        heap = new  int[list.size()];

        for(int i=0;i<list.size();i++){
            heap[i] = list.get(i);
        }

        int pozice = heap.length/2-1;
        for(int i=pozice;i>=0;i--) {
            zkontroluj(i);
        }
        for(int i=0;i<heap.length;i++){
            System.out.print((int)(heap[i]));
        }
    }
    public static void zkontroluj(int pozice){
        while(true){
            int dite1 = pozice * 2 + 1;
            int dite2 = pozice * 2 + 2;

            if(dite1 >= heap.length){
                return;
            }

            int mensiDite = dite1;
            if(dite2 < heap.length && heap[dite2] < heap[dite1]){
                mensiDite = dite2;
            }
            if(heap[pozice] <= heap[mensiDite]){
                return;
            }
            int temp = heap[pozice];
            heap[pozice] = heap[mensiDite];
            heap[mensiDite] = temp;

            pozice = mensiDite;
        }
    }
}
