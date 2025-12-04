package Hodina_12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Databaze {
    public static void main(String[] args) throws SQLException {
        List<Clovek> lidi = new ArrayList<Clovek>();
        lidi.add(new Clovek("Jan", "Novak", 1));
        lidi.add(new Clovek("Pepa", "Pizl", 2));
        lidi.add(new Clovek("Pyzlyno", "pepyk", 3));

        System.out.println(lidi);

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db")) {
            try (Statement stmt = conn.createStatement()) {

                stmt.execute("CREATE TABLE IF NOT EXISTS people (jmeno VARCHAR, prijmeni VARCHAR, rocnik int)");

                for(Clovek cl : lidi) {
                    String jmeno = cl.getJmeno();
                    String prijmeni = cl.getPrijmeni();
                    int rocnik = cl.getRocnik();
                    try(Statement stmt2 = conn.createStatement()) {
                        String str = "'" + jmeno + "', '" + prijmeni + "', '" + rocnik + "'";
                        stmt2.executeUpdate("INSERT INTO people VALUES (" + str + ")");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
