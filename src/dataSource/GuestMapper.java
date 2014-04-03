/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Guest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jakobgaardandersen
 */
public class GuestMapper
{

    public Guest checkLogin(String username, String password, Connection con)
    {
        String SQLString = "SELECT * from GUESTS where upper(username) = upper(?) and password = ?";

        PreparedStatement statement = null;
        Guest g = null;

        try
        {
            statement = con.prepareStatement(SQLString);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            if(rs.next())
            {
                g = new Guest(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10));
            }

        } catch (SQLException e)
        {
            System.out.println("Fail in GuestMapper - checkLogin");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in RoomMapper GuestMapper - checkLogin");
                System.out.println(e.getMessage());
            }
        }
        return g;
    }

}
