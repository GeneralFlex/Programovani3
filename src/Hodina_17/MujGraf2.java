package Hodina_17;

import java.util.*;

public class MujGraf2 {
    static ArrayList<Vrchol> vrcholy = new ArrayList<>();
    static Map<Vrchol, Set<Vrchol>> map = new HashMap<>();

    public static void main(String[] args) {
        vyrobDomecek();
        vypisHrany();
    }

    public static void vyrobDomecek(){
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

        vytvorHranu(vrchol1,vrchol2);
        vytvorHranu(vrchol1,vrchol3);
        vytvorHranu(vrchol2,vrchol4);
        vytvorHranu(vrchol3,vrchol5);
        vytvorHranu(vrchol3,vrchol4);
        vytvorHranu(vrchol4,vrchol5);
        vytvorHranu(vrchol4,vrchol6);
        vytvorHranu(vrchol4,vrchol7);
        vytvorHranu(vrchol5,vrchol8);
    }

    public static Vrchol vytvorVrchol(String jmeno) {
        Vrchol vrchol = new Vrchol(jmeno);
        map.put(vrchol, new HashSet<>());
        return vrchol;
    }

    public static void vytvorHranu(Vrchol a, Vrchol b){
        Set<Vrchol> setA = map.get(a);
        setA.add(b);
        map.put(a,setA);
        Set<Vrchol> setB = map.get(b);
        setB.add(a);
        map.put(b,setB);
    }

    public static void vypisHrany(){
        for(Vrchol k : map.keySet()){
            System.out.println("Vrchol: "+k.jmeno);
            Set<Vrchol> setK = map.get(k);
            for(Vrchol k2 : setK){
                System.out.println("     - "+k2.jmeno);
            }
        }
    }
}
