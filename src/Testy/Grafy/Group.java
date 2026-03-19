package Testy.Grafy;

import java.util.*;

public class Group {
    static Set<Map<Vrchol, Integer>> groups = new HashSet<Map<Vrchol, Integer>>();
    static MujGraf mujGraf = new MujGraf();
    static List<Vrchol> vrcholy = mujGraf.getVrcholy();
    static List<Hrana> hrany = mujGraf.getHrany();
    static Queue<Vrchol> neprohledane = new ArrayDeque<>();
    static Queue<Vrchol> vrcholyKprohledani = new ArrayDeque<>();
    
    public static void main(String[] args) {
        neprohledane.addAll(vrcholy);
        while (!neprohledane.isEmpty()) {
            Vrchol vrchol = neprohledane.poll();
            Map<Vrchol, Integer> group = new HashMap<Vrchol, Integer>();
            groups.add(group);
            prohledejCastGrafu(vrchol, group);
        }

        for(Map<Vrchol, Integer> group : groups){
            for(Vrchol vrchol : group.keySet()){
                System.out.print(vrchol.getName() + " ");
            }
            System.out.println(getGroupSize(group));
        }
    }

    public static int getGroupSize(Map<Vrchol, Integer> group) {
        int sum = 0;
        for(Vrchol vrchol : group.keySet()){
            sum += group.get(vrchol);
        }
        return sum;
    }

    public static void prohledejCastGrafu(Vrchol v, Map<Vrchol, Integer> group) {
        //vloz vrchol do skupiny
        group.put(v, v.getHodnota());
        List<Vrchol> sousedi = mujGraf.sousedi(v);

        //odeber
        neprohledane.remove(v);

        for (Vrchol vrchol : sousedi) {
            if(!vrcholyKprohledani.contains(vrchol)&&!group.containsKey(vrchol)) {
                vrcholyKprohledani.add(vrchol);
            }
        }

        if(!vrcholyKprohledani.isEmpty()) {
            prohledejCastGrafu(vrcholyKprohledani.poll(), group);
        }

    }
}
