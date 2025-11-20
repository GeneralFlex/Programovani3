package Hodina_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Mojedatabaze {
    public static void main(String[] args) throws SQLException {
        List<Clovek> lidi = new ArrayList<Clovek>();
        lidi.add(new Clovek("Jan", "Novak", 1));
        lidi.add(new Clovek("Pepa", "Pizl", 2));
        lidi.add(new Clovek("Pyzlyno", "pepik", 3));

        System.out.println(lidi);

        try(Connection conn = DriverManager.getConnection("jdbc: ......", null, null)) {
            try (Statement stmt = conn.createStatement()) {
                for(Clovek cl : lidi) {
                    String jmeno = cl.getJmeno();
                    String prijmeni = cl.getPrijmeni();
                    int rocnik = cl.getRocnik();
                    String str = "'"+jmeno+"', '"+prijmeni+"', '"+rocnik+"'";
                    System.out.println("INSERT INTO people(jmeno, prijmeni, rocnik) VALUES ("+str+")");
                    stmt.executeUpdate("INSERT INTO people(jmeno, prijmeni, rocnik) VALUES ("+str+")");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
