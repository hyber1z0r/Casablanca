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

    public boolean checkLogin(String username, String password, Connection con)
    {
        String SQLString = "SELECT GUEST_ID from GUESTS where upper(username) = upper(?) and password = ?";

        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            return rs.next();

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
        return false;
    }

}
