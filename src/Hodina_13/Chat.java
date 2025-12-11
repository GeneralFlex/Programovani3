package Hodina_13;

import Hodina_11.Clovek;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {
    static int pocetZprav = 0;
    static String autor = "Vincent";
    public static void main(String[] args) throws SQLException {

        try(Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani");) {

            Thread t = new Thread(() -> {
                //update chat
                while(true) {
                    try (Statement stmt = conn.createStatement()) {
                        ResultSet rs = stmt.executeQuery("SELECT MAX(poradi) FROM zprava");
                        if (rs.next()) {
                            pocetZprav = rs.getInt(1);
                        }
                        System.out.println(pocetZprav);
                        ResultSet rs2 = stmt.executeQuery("SELECT * FROM zprava");
                        ResultSetMetaData rsmd = rs2.getMetaData();
                        int columnsNumber = rsmd.getColumnCount();
                        while (rs2.next()) {
                            for (int i = 1; i <= columnsNumber; i++) {
                                if (i > 1) System.out.print(",  ");
                                String columnValue = rs2.getString(i);
                                System.out.print(columnValue);
                            }
                            System.out.println("");
                        }
                        Thread.sleep(10000);
                    }
                    catch (SQLException e) {
                        throw new RuntimeException(e);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.start();


            try (Statement stmt = conn.createStatement()) {

                for(;;) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("napiste zpravu:");
                    String msg =  sc.nextLine();
                    String str = "'"+(pocetZprav+1)+"', '"+autor+"', '"+msg+"'";
                    stmt.executeUpdate("INSERT INTO zprava VALUES ("+str+")");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
