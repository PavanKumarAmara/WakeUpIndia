package com.example.pavan_6860.wakeupindia.db;

import android.content.Context;
import android.widget.Toast;

import com.example.pavan_6860.wakeupindia.R;
import com.example.pavan_6860.wakeupindia.model.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
    static boolean  saveRecord(Context context,Record record){
        Connection connection=DbHelper.getConnection(context);
        try {
            PreparedStatement statement=connection.prepareStatement("insert into images values(?,?)");
            statement.setString(1,record.getUserName());
            statement.setBlob(2,record.getImage());
           int noOfRecordsUpdated= statement.executeUpdate();
           if(noOfRecordsUpdated==1){
               Toast.makeText(context,context.getResources().getString(R.string.success_msg),Toast.LENGTH_LONG).show();
           }
            DbHelper.closeConnection(context);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
   }
    public static boolean  verifyRecord(Context context,Record record){
        Connection connection=DbHelper.getConnection(context);
        try {
            PreparedStatement statement=connection.prepareStatement("select password from users where user_name=?");
            statement.setString(1,record.getUserName());
            ResultSet rs= statement.executeQuery();
            if(rs.next()){
                if(rs!=null && rs.getString(1)!=null){
                    if(rs.getString(1).equals(record.getPassword())){
                        return true;
                    }
                }
                Toast.makeText(context,context.getResources().getString(R.string.success_msg),Toast.LENGTH_LONG).show();
            }
            DbHelper.closeConnection(context);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    }
