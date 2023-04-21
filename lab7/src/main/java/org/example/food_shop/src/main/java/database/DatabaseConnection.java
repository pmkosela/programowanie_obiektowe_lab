package org.example.food_shop.src.main.java.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        return connection;
    }
    public static boolean connect(){
         try{
             connection = DriverManager.getConnection("jdbc:sqlite:shop_data.db");
         } catch (SQLException exception) {
             exception.printStackTrace();
         }
         return true;
    }

    public static boolean disconnect(){
        try{
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return true;
    }

    private static Connection connection;

}
