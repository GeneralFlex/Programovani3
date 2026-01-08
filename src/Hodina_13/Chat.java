package Hodina_13;

import Hodina_11.Clovek;

import java.sql.*;
import java.util.*;

public class Chat {
    static int pocetZprav = 0;
    static int pocetZpravToPrint = 0;
    static String autor = "Vincent";
    //static Dictionary<Integer,String> zpravy = new Hashtable<>();
    public static void main(String[] args) throws SQLException {

        try(Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani");) {

            Thread t = new Thread(() -> {
                //update chat
                GetChat(conn);
            });
            t.start();


            try (Statement stmt = conn.createStatement()) {

                for(;;) {
                    Scanner sc = new Scanner(System.in);
                    String msg =  sc.nextLine();
                    String str = "'"+(pocetZprav+1)+"', '"+autor+"', '"+msg+"'";
                    stmt.executeUpdate("INSERT INTO zprava VALUES ("+str+")");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void GetChat(Connection conn) {
        while(true) {
            try (Statement stmt = conn.createStatement()) {

                //get table
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM zprava WHERE poradi > " + pocetZprav + " ORDER BY poradi");
                ResultSetMetaData rsmd = rs2.getMetaData();
                int columnsNumber = rsmd.getColumnCount();

                //print table
                while (rs2.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs2.getString(i);
                        System.out.print(columnValue);
                    }
                    System.out.println("");
                }

                //get pocetZprav
                ResultSet rs = stmt.executeQuery("SELECT MAX(poradi) FROM zprava");
                if (rs.next()) {
                    pocetZprav = rs.getInt(1);
                }

                Thread.sleep(1000);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
