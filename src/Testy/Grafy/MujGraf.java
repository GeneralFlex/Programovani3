package Testy.Grafy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MujGraf {
    private final List<Vrchol> vrcholy = Arrays.asList(
            new Vrchol("A", 1),
            new Vrchol("B", 2),
            new Vrchol("C", 3),
            new Vrchol("D", 4),
            new Vrchol("E", 100),
            new Vrchol("F", 55),
            new Vrchol("bruh", 800000),
            new Vrchol("H", 6),
            new Vrchol("I", 333),
            new Vrchol("Jjjjjjjjjj", 2)
    );

    public List<Vrchol> getVrcholy() {
        return vrcholy;
    }

    private final List<Hrana> hrany = Arrays.asList(
            new Hrana(vrcholy.get(0), vrcholy.get(1)),
            new Hrana(vrcholy.get(1), vrcholy.get(2)),
            new Hrana(vrcholy.get(3), vrcholy.get(4)),
            new Hrana(vrcholy.get(5), vrcholy.get(6)),
            new Hrana(vrcholy.get(5), vrcholy.get(7)),
            new Hrana(vrcholy.get(8), vrcholy.get(9))
    );

    public List<Hrana> getHrany() {
        return hrany;
    }

    public List<Vrchol> sousedi(Vrchol v) {
        return hrany.stream().map(x -> x.soused(v)).filter(Objects::nonNull).toList();
    }
}
