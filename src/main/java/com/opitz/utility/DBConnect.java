package com.opitz.utility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@Deprecated
public class DBConnect  {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelDB","root","");
            st = con.createStatement();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }


    public void getData() {
        try {
            String query = "select * from users";
            rs = st.executeQuery(query);
            System.out.println("Rescords from db: ");
            while(rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                System.out.println("username: " + username + "  email:" + email);
            }
        } catch(Exception ex){
            System.out.println(ex);
        }

    }

}
