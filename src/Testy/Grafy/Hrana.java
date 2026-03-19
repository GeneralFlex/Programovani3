package Testy.Grafy;

public class Hrana {
    private final Vrchol v1;
    private final Vrchol v2;

    public Hrana(Vrchol vrchol1, Vrchol vrchol2) {
        v1 = vrchol1;
        v2 = vrchol2;
    }

    public Vrchol soused(Vrchol v) {
        return v1.equals(v) ? v2 : (v2.equals(v) ? v1 : null);
    }
}
