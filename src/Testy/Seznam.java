package Testy;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Seznam {
    public static void main(String[] args) throws SQLException {

        try (var conn = DriverManager.getConnection("jdbc:postgresql:")) {
            try (Statement stmt = conn.createStatement()) {
                //uzivatel id
                ResultSet rs = stmt.executeQuery("SELECT * FROM vypujcka");
                //ziskat id
                int uzivatelId=0;
                int knihaId=0;
                if(rs.next()) {
                    uzivatelId = rs.getInt(1);
                    knihaId = rs.getInt(2);
                }

                //ziskat jmena
                String uzivatelJm = "";
                String knihaJm = "";

                ResultSet rs2 = stmt.executeQuery("SELECT * FROM uzivatel WHERE id = '" + uzivatelId+"'");
                if(rs2.next()) {
                    uzivatelJm = rs2.getString(2);
                }

                ResultSet rs3 = stmt.executeQuery("SELECT * FROM kniha WHERE id = '" + knihaId+"'");
                if(rs3.next()) {
                    knihaJm = rs3.getString(2);
                }

                System.out.println(uzivatelJm+": "+knihaJm);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
