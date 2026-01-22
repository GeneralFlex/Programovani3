package Hodina_15;

import java.util.ArrayList;
import java.util.HashMap;

public class MujGraf {
    static ArrayList<Vrchol> vrcholy = new ArrayList<>();
    static HashMap<Vrchol, Integer> pocetHranUVrcholu = new HashMap<>();
    static ArrayList<Hrana> hrany = new ArrayList<>();
    public void vyrobDomecek(){
        Vrchol vrcholA = new Vrchol("A");
        Vrchol vrcholB = new Vrchol("B");
        Vrchol vrcholC = new Vrchol("C");
        Vrchol vrcholD = new Vrchol("D");
        Vrchol vrcholE = new Vrchol("E");
        vrcholy.add(vrcholA);
        vrcholy.add(vrcholB);
        vrcholy.add(vrcholC);
        vrcholy.add(vrcholD);
        vrcholy.add(vrcholE);

        hrany.add(new Hrana(vrcholA,vrcholB));
        hrany.add(new Hrana(vrcholA,vrcholC));
        hrany.add(new Hrana(vrcholB,vrcholC));
        hrany.add(new Hrana(vrcholB,vrcholD));
        hrany.add(new Hrana(vrcholD,vrcholE));
        hrany.add(new Hrana(vrcholE,vrcholC));
        hrany.add(new Hrana(vrcholB,vrcholE));
        hrany.add(new Hrana(vrcholD,vrcholC));
    }

    public static void main(String[] args) {
        MujGraf g = new MujGraf();
        g.vyrobDomecek();

        for(Vrchol vrchol : vrcholy) {
            pocetHranUVrcholu.put(vrchol,0);
        }

        System.out.println("Hrany grafu:");
        for(Hrana hrana : hrany){
            System.out.println("vrchol: "+hrana.vrcholA.jmeno+"; vrchol: "+ hrana.vrcholB.jmeno);
            pocetHranUVrcholu.compute(hrana.vrcholA, (k, current) -> current + 1);

            pocetHranUVrcholu.compute(hrana.vrcholB, (k, currentB) -> currentB + 1);
        }
        System.out.println("Pocet hran u vrcholu:");
        for(Vrchol vrchol : vrcholy){
            System.out.println("Vrchol: "+vrchol.jmeno+" - "+pocetHranUVrcholu.get(vrchol));
        }
    }
}
