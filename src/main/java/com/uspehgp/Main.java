package com.uspehgp;

import java.sql.*;

public class Main {
    public static void main(String[] arg){
        Long contactId = 1L;
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "995959");
            PreparedStatement statement = conn.prepareStatement(
                    "select c.first_name, c.last_name, count(pn.phone_number) from contact as c\n" +
                    "left join phone_number as pn on pn.contact_id=c.id\n" +
                    "where c.id=?" + "\n" +
                    "group by c.first_name, c.last_name;");
            statement.setLong(1, contactId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                System.out.println(
                        resultSet.getString("first_name")+"\t"+
                                resultSet.getString("last_name")+"\t"+
                                resultSet.getInt("count")
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
