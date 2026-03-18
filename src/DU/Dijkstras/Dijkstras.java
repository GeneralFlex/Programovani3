package DU.Dijkstras;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Dijkstras {
    static Map<Vrchol, List<Hrana>> mapa = new HashMap<Vrchol, List<Hrana>>();
    static Map<Long, Vrchol> vrcholy = new HashMap<Long, Vrchol>();

    public static void main(String[] args) throws IOException {
        nactiData();
        Scanner sc = new Scanner(System.in);
        long start = sc.nextLong();
        long end = sc.nextLong();
        dijkstras(start, end);
    }
    //test

    public static void dijkstras(long start, long end) {
        Map<Long, Long> cesty = new HashMap<>();
        Map<Long, Double> vzdalenosti = new HashMap<>();
        Queue<Long> fronta = new ArrayDeque<>();

        // Inicializace
        for(long id : vrcholy.keySet()){
            cesty.put(id, null);
            vzdalenosti.put(id, Double.MAX_VALUE);
        }
        vzdalenosti.put(start, 0.0);
        fronta.add(start);

        while(!fronta.isEmpty()){
            // nejblizsi
            long nejblizsiID = -1;
            for(long id : fronta){
                if(nejblizsiID == -1 || vzdalenosti.get(id) < vzdalenosti.get(nejblizsiID)){
                    nejblizsiID = id;
                }
            }

            double currentDist = vzdalenosti.get(nejblizsiID);

            // sousedi
            for(Hrana hrana : mapa.get(vrcholy.get(nejblizsiID))){
                long sousedId = (hrana.id1 == nejblizsiID) ? hrana.id2 : hrana.id1;
                double novaVzdalenost = currentDist + hrana.delka;

                if(novaVzdalenost < vzdalenosti.get(sousedId)){
                    vzdalenosti.put(sousedId, novaVzdalenost);
                    cesty.put(sousedId, nejblizsiID);
                    fronta.add(sousedId);
                }
            }

            // vyrazeni
            fronta.remove(nejblizsiID);
        }

        // vypsani cesty a vzdalenosti
        System.out.println(vzdalenosti.get(end)+" m");
        vypisCestu(cesty, start, end);
    }

    public static void vypisCestu(Map<Long, Long> cesty, long start, long end) {
        if(start == end) {
            System.out.print(start);
            return;
        }
        vypisCestu(cesty, start, cesty.get(end));
        System.out.println(end);
    }

    public static void nactiData() throws IOException {

        Scanner sc = new Scanner(Paths.get("praha_uzly.csv"));
        sc.useLocale(Locale.US);

        Scanner sc2 = new Scanner(Paths.get("praha_hrany.csv"));
        sc2.useLocale(Locale.US);

        while(sc.hasNext()) {
            long id = sc.nextLong();
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            Vrchol vrchol = new Vrchol(id, x, y);
            mapa.put(vrchol, new ArrayList<Hrana>());
            vrcholy.put(id, vrchol);
        }
        sc.close();

        while(sc2.hasNext()) {
            long id1 = sc2.nextLong();
            long id2 = sc2.nextLong();
            double delka = sc2.nextDouble();
            String jmeno = sc2.nextLine();

            Hrana hrana = new Hrana(id1, id2, delka, jmeno);
            Vrchol vrchol1 = vrcholy.get(id1);
            Vrchol vrchol2 = vrcholy.get(id2);

            mapa.get(vrchol1).add(hrana);
            mapa.get(vrchol2).add(hrana);
        }
        sc2.close();
    }
}


