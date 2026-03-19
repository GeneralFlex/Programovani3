package DU.Dijkstras;

public class Hrana {
    long id1;
    long id2;
    double delka;
    String jmeno;

    public Hrana(long id1, long id2, double delka, String jmeno) {
        this.id1 = id1;
        this.id2 = id2;
        this.delka = delka;
        this.jmeno = jmeno;
    }

    public long getId2() {
        return id2;
    }

    public long getId1() {
        return id1;
    }

    public double getDelka() {
        return delka;
    }
}
