package com.example.pavan_6860.wakeupindia.db;

import android.content.Context;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    public static Connection connection;
    public static Connection getConnection(Context context){
        try{
            if(connection==null){
                Class.forName("com.mysql.jdbc.Driver");
                connection=DriverManager.getConnection(
                        "jdbc:mysql://wakeupindia.cd3itqhujbgs.us-east-1.rds.amazonaws.com:3306/wake_up_india","pavan","IAMpavan143");
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
    public static boolean closeConnection(Context context) {
        try {
            if (connection != null) {

                connection.close();
            }
        }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        return true;
    }
}
