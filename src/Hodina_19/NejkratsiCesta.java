package Hodina_19;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class NejkratsiCesta {

    static Map<Vrchol, List<Hrana>> mapa = new HashMap<Vrchol, List<Hrana>>();
    static Map<Long, Vrchol> vrcholy = new HashMap<Long, Vrchol>();

    private static void nactiData() throws IOException {

        //VRCHOLY
        Scanner sc = new Scanner(Paths.get("src/Hodina_19/praha_uzly.csv"));
        sc.useLocale(Locale.US);

        while(sc.hasNext()) {
            long id = sc.nextLong();
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            Vrchol vrchol = new Vrchol(id, x, y);

            vrcholy.put(id,vrchol);
            mapa.put(vrchol, new ArrayList<Hrana>());
        }

        //HRANY
        Scanner sc2 = new Scanner(Paths.get("src/Hodina_19/praha_hrany.csv"));
        sc2.useLocale(Locale.US);

        while(sc2.hasNext()) {
            long id1 = sc2.nextLong();
            long id2 = sc2.nextLong();
            double delka = sc2.nextDouble();
            String jmeno = sc2.nextLine();

            Hrana hrana = new Hrana(id1, id2, delka, jmeno);

            Vrchol vrchol = vrcholy.get(id1);

            List<Hrana> hrany = mapa.get(vrchol);
            hrany.add(hrana);
            mapa.put(vrchol, hrany);
        }
    }

    public static void main(String[] args) throws IOException {
        nactiData();
        List<Hrana> test = mapa.get(vrcholy.get((long)172512));
        for(Hrana hrana : test) {
            System.out.println("id1: "+hrana.id1);
            System.out.println("id2: "+hrana.id2);
            System.out.println("delka: "+hrana.delka);
            System.out.println("jmeno: "+hrana.jmeno);
            System.out.println("----------------------");
        }
    }
}
