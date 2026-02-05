package Hodina_15;

import java.lang.reflect.Array;
import java.util.*;

public class MujGraf {
    static int currID=0;
    static ArrayList<Vrchol> vrcholy = new ArrayList<>();
    static HashMap<Vrchol, Integer> pocetHranUVrcholu = new HashMap<>();
    static HashMap<Vrchol, ArrayList<Hrana>> hranyUVrcholu = new HashMap<>();
    static ArrayList<Hrana> hrany = new ArrayList<>();

    public void vyrobDomecek(){
        Vrchol vrchol1 = vytvorVrchol("1");
        Vrchol vrchol2 = vytvorVrchol("2");
        Vrchol vrchol3 = vytvorVrchol("3");
        Vrchol vrchol4 = vytvorVrchol("4");
        Vrchol vrchol5 = vytvorVrchol("5");
        Vrchol vrchol6 = vytvorVrchol("6");
        Vrchol vrchol7 = vytvorVrchol("7");
        Vrchol vrchol8 = vytvorVrchol("8");
        vrcholy.add(vrchol1);
        vrcholy.add(vrchol2);
        vrcholy.add(vrchol3);
        vrcholy.add(vrchol4);
        vrcholy.add(vrchol5);
        vrcholy.add(vrchol6);
        vrcholy.add(vrchol7);
        vrcholy.add(vrchol8);

        hrany.add(new Hrana(vrchol1,vrchol2));
        hrany.add(new Hrana(vrchol1,vrchol3));
        hrany.add(new Hrana(vrchol2,vrchol4));
        hrany.add(new Hrana(vrchol3,vrchol5));
        hrany.add(new Hrana(vrchol3,vrchol4));
        hrany.add(new Hrana(vrchol4,vrchol5));
        hrany.add(new Hrana(vrchol4,vrchol6));
        hrany.add(new Hrana(vrchol4,vrchol7));
        hrany.add(new Hrana(vrchol5,vrchol8));
    }

    public static void main(String[] args) {
        MujGraf g = new MujGraf();
        g.vyrobDomecek();
        for(Vrchol vrchol : vrcholy) {
            pocetHranUVrcholu.put(vrchol,0);
            System.out.println(vrchol.jmeno+"; id: "+vrchol.id);
        }

        System.out.println("Hrany grafu:");
        for(Hrana hrana : hrany){
            System.out.println("vrchol: "+hrana.vrcholA.jmeno+"; vrchol: "+ hrana.vrcholB.jmeno);
            PridejDoListu(hrana);
        }
        /*
        System.out.println("Pocet hran u vrcholu:");
        for(Vrchol vrchol : vrcholy){
            System.out.println("Vrchol: "+vrchol.jmeno+" - "+pocetHranUVrcholu.get(vrchol));
        }
        System.out.println("Projiti grafu:");
        ProjdiVrcholy(vrcholy.getFirst());

         */

        System.out.println("Projiti grafu do hloubky:");
        ProjdiVrcholyHloubka(vrcholy.getFirst());

        System.out.println("Projiti grafu do sirky:");
        ProjdiVrcholySirka(vrcholy.getFirst());
    }
    public static Vrchol vytvorVrchol(String jmeno) {
        Vrchol vrchol = new Vrchol(jmeno,currID);
        currID++;
        return vrchol;
    }

    public static void PridejDoListu(Hrana hrana){
        pocetHranUVrcholu.compute(hrana.vrcholA, (k, current) -> current + 1);
        ArrayList<Hrana> temp = new ArrayList<>();
        if(hranyUVrcholu.containsKey(hrana.vrcholA)){
            temp = hranyUVrcholu.get(hrana.vrcholA);
            hranyUVrcholu.remove(hrana.vrcholA);
        }
        temp.add(hrana);
        hranyUVrcholu.put(hrana.vrcholA, temp);

        pocetHranUVrcholu.compute(hrana.vrcholB, (k, currentB) -> currentB + 1);

        ArrayList<Hrana> temp2 = new ArrayList<>();
        if(hranyUVrcholu.containsKey(hrana.vrcholB)){
            temp2 = hranyUVrcholu.get(hrana.vrcholB);
            hranyUVrcholu.remove(hrana.vrcholB);
        }
        temp2.add(hrana);
        hranyUVrcholu.put(hrana.vrcholB, temp2);
    }

    public static ArrayList<Vrchol> KamMuzuJit(Vrchol start) {
        ArrayList<Vrchol> vrcholy = new ArrayList<>();

        for(Hrana hrana : hranyUVrcholu.get(start)){
            Vrchol cil = start == hrana.vrcholA ? hrana.vrcholB : hrana.vrcholA;
            vrcholy.add(cil);
            //System.out.println("     "+start.jmeno+" -> "+cil.jmeno);
        }

        return vrcholy;
    }

    public static void ProjdiVrcholy(Vrchol start){
        System.out.println("Vrchol: "+ start.jmeno+" - prolezen");
        start.visited = true;
        ArrayList<Vrchol> kamMuzuJit = KamMuzuJit(start);
        for(Vrchol vrchol : kamMuzuJit){
            if(vrchol.visited){
                continue;
            }
            ProjdiVrcholy(vrchol);
            return;
        }
    }

    public static void ProjdiVrcholyHloubka(Vrchol start){
        Deque<Vrchol> zasobnik = new ArrayDeque<Vrchol>();
        zasobnik.push(start);
        start.visited=true;
        while(!zasobnik.isEmpty()){
            Vrchol momentalniVrchol = zasobnik.pop();
            System.out.println("Navstiven vrchol: "+momentalniVrchol.jmeno);
            ArrayList<Vrchol> kamMuzuJit = KamMuzuJit(momentalniVrchol);

            for(Vrchol soused : kamMuzuJit){
                if(!soused.visited) {
                    zasobnik.push(soused);
                    soused.visited=true;
                }
            }
        }
        for(Vrchol vrchol : vrcholy){
            vrchol.visited=false;
        }
    }
    public static void ProjdiVrcholySirka(Vrchol start){
        Queue<Vrchol> zasobnik = new ArrayDeque<>();
        zasobnik.add(start);
        start.visited=true;
        while(!zasobnik.isEmpty()){
            Vrchol momentalniVrchol = zasobnik.poll();
            System.out.println("Navstiven vrchol: "+momentalniVrchol.jmeno);
            ArrayList<Vrchol> kamMuzuJit = KamMuzuJit(momentalniVrchol);

            for(Vrchol soused : kamMuzuJit){
                if(!soused.visited) {
                    zasobnik.add(soused);
                    soused.visited=true;
                }
            }
        }
        for(Vrchol vrchol : vrcholy){
            vrchol.visited=false;
        }
    }
}
