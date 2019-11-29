package web;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataStorage {

    public DataStorage() {

    }

    public void addToDb(String num1, String num2, String op,String result,String user_name){
        Connection conn=DbConnection.getConnection();
        try{
            final String SQLI = "INSERT INTO calchistory (num1,num2,op,result,user_name) values (?, ?, ?, ?, ?)";
            PreparedStatement stmt_insert = conn.prepareStatement(SQLI);
            stmt_insert.setInt(1, Integer.parseInt(num1));
            stmt_insert.setInt(2, Integer.parseInt(num2));
            stmt_insert.setString(3, op);
            stmt_insert.setString(4,result);
            stmt_insert.setString(5,user_name);
            stmt_insert.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
