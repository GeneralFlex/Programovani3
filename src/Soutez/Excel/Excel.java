package Soutez.Excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Excel {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("table.txt"));
        List<List<String>> sloupce = new ArrayList<>();

        String row1 = sc.nextLine();
        List<String> headings = List.of(row1.split("\\s+"));
        for (int i = 0; i < headings.size(); i++) {
            List<String> column = new ArrayList<>();
            column.add(headings.get(i));
            sloupce.add(column);
        }

        int rowLine=1;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            List<String> row = List.of(line.split("\\s+"));
            for (int i = 0; i < sloupce.size(); i++) {
                try {
                    sloupce.get(i).add(row.get(i));
                }catch(Exception ignored){
                    //+1 protoze radek v souboru x 1. radek ve vstupu (error v headings byt nemuze?, pak bude error u vsech radku) -> 2 varianty
                    System.out.println("ROW "+(rowLine+1)+" FORMAT ERROR");
                    System.exit(0);
                }
            }
            rowLine++;
        }
        for (List<String> col : sloupce) {
            for (int i = 1; i < col.size()-2; i++) {
                if(getFormat(col.get(i)).equals(getFormat(col.get(i + 1)))){
                    //spravny format
                }else{
                    System.out.println("COLUMN "+col.getFirst()+" FORMAT ERROR");
                    System.exit(0);
                }
            }
        }
        for(List<String> col : sloupce){
            switch (col.getLast()){
                case "AVG": {
                    if(getFormat(col.get(1)).equals("cisla")) {
                        System.out.print("\n" + col.getLast() + " " + col.getFirst() + ": ");
                        avg(col);
                    }
                    break;
                }case "MAX": {
                    if(getFormat(col.get(1)).equals("cisla")) {
                        System.out.print("\n" + col.getLast() + " " + col.getFirst() + ": ");
                        max(col);
                    }
                    break;
                }case "MIN": {
                    if(getFormat(col.get(1)).equals("cisla")) {
                    System.out.print("\n"+col.getLast() +" "+col.getFirst()+": ");
                    min(col);
                    }
                    break;
                }case "PRINT": {
                    if(getFormat(col.get(1)).equals("pismena")) {
                        System.out.print("\n" + col.getLast() + " " + col.getFirst() + ":");
                        print(col);
                    }
                    break;
                }case "SORT": {
                    if(getFormat(col.get(1)).equals("pismena")) {
                        System.out.print("\n" + col.getLast() + " " + col.getFirst() + ":");
                        sort(col);
                    }
                    break;
                }default:{break;}
            }
        }


        sc.close();
    }
    public static void sort(List<String> col) {
        String[] sorted = new String[col.size() - 2];

        for (int j = 0; j < sorted.length; j++) {
            int nejdriv = 1;

            for (int i = 2; i < col.size() - 1; i++) {
                if (col.get(i).compareTo(col.get(nejdriv)) < 0) {
                    nejdriv = i;
                }
            }

            sorted[j] = col.get(nejdriv);
            col.remove(nejdriv);
        }

        for (String s : sorted) {
            System.out.print(" " + s);
        }
    }
    public static void print(List<String> col) {
        for(int i=1;i<col.size()-1;i++){
            System.out.print(" "+col.get(i));
        }
    }
    public static void min(List<String> col) {
        int min=Integer.MAX_VALUE;
        for(int i=1;i<col.size()-1;i++){
            if (min > Integer.parseInt(col.get(i))){
                min = Integer.parseInt(col.get(i));
            }
        }
        System.out.print(min);
    }
    public static void max(List<String> col) {
        int max=0;
        for(int i=1;i<col.size()-1;i++){
            if (max < Integer.parseInt(col.get(i))){
                max = Integer.parseInt(col.get(i));
            }
        }
        System.out.print(max);
    }

    public static void avg(List<String> col) {
        int sum=0;
        for(int i=1;i<col.size()-1;i++){
            sum+=Integer.parseInt(col.get(i));
        }
        System.out.print(sum/(col.size()-2));
    }

    public static String getFormat(String line) {
        try {
            Integer.parseInt(line);
        } catch(NumberFormatException e) {
            return "pismena";
        }
        return "cisla";
    }
}
