package Testy;

import java.sql.*;
import java.util.Scanner;

public class Knihovna {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        //for (;;) {
            String uzivatel = sc.next();
            String kniha = sc.nextLine().trim();

            if (uzivatel.isEmpty() || kniha.isEmpty()) {
                System.out.println("spatny vstup");
                //continue;
            } else{
                zapisDoTabulky(uzivatel, kniha);
            }

        //}

    }

    public static void zapisDoTabulky(String uzivatelJm, String knihaJm) throws SQLException {
        //System.out.println("Uzivatel: "+uzivatel);
        //System.out.println("Kiha: "+kniha);

        try (var conn = DriverManager.getConnection("jdbc:postgresql:")) {
            int idUzivatel;
            int idKniha;

            try (Statement stmt = conn.createStatement()) {
                //uzivatel id
                ResultSet rs = stmt.executeQuery("SELECT * FROM uzivatel WHERE prijmeni = '" + uzivatelJm+"'");

                if (!rs.next()) {
                    System.out.println("neznamy uzivatel");
                    return;
                }

                idUzivatel = rs.getInt("id");

                //kniha id
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM kniha WHERE jmeno = '" + knihaJm+"'");
                if(!rs2.next()) {
                    System.out.println("neznama kniha");
                    return;
                }
                idKniha = rs2.getInt(1);

                //vkladani do tabulky
                //vraceni knihy
                ResultSet rs3 = stmt.executeQuery("SELECT * FROM vypujcka WHERE id_kniha = '" + idKniha+"' AND vraceno IS NULL");
                if(rs3.next()) {
                    stmt.executeUpdate("UPDATE vypujcka SET vraceno = CURRENT_TIMESTAMP WHERE id_kniha = '" + idKniha+"'");
                } else{
                    String str = "'"+idUzivatel+"', '"+idKniha+"'";
                    stmt.executeUpdate("INSERT INTO vypujcka VALUES ("+str+", CURRENT_TIMESTAMP, NULL)");
                }

            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }

        }catch(SQLException e){
            System.out.println("chyba " + e.getMessage());
        }
    }

}
