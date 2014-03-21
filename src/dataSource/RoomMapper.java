/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hyber
 */
public class RoomMapper
{
    //== load an order and the associated order details

    public ArrayList<String> getAllFreeRooms(String sDate, String eDate, Connection con)
    {
        ArrayList<String> rooms = new ArrayList();
        String SQLString1 = "SELECT * FROM ROOMS r Where room_id not in "
                + "(SELECT room_id from bookings b where "
                + "(b.START_date < ? and b.End_date > ?) "
                + "or (b.Start_date > ? and b.Start_date < ?)) "
                + "order by room_id";
        PreparedStatement statement = null;

        try
        {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, sDate);
            statement.setString(2, eDate);
            statement.setString(3, sDate);
            statement.setString(4, eDate);     // primary key value
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
                rooms.add(rs.getInt(1) + rs.getInt(2) + "");
            }

        } catch (SQLException e)
        {
            System.out.println("Fail in RoomMapper - getRooms");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in RoomMapper - getRooms");
                System.out.println(e.getMessage());
            }
        }
        return rooms;
    }
     public ArrayList<String> getSizeFreeRooms(String sDate, String eDate, int rSize, Connection con)
    {
        ArrayList<String> rooms = new ArrayList();
        String SQLString1 = "SELECT * FROM ROOMS r Where room_size = ? and room_id not in "
                + "(SELECT room_id from bookings b where "
                + "(b.START_date < ? and b.End_date > ?) "
                + "or (b.Start_date > ? and b.Start_date < ?)) "
                + "order by room_id";
        PreparedStatement statement = null;

        try
        {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, rSize);
            statement.setString(2, sDate);
            statement.setString(3, eDate);
            statement.setString(4, sDate);
            statement.setString(5, eDate);
            // primary key value
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
                rooms.add(rs.getInt(1) + rs.getInt(2) + "");
            }

        } catch (SQLException e)
        {
            System.out.println("Fail in RoomMapper - getRooms");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in RoomMapper - getRooms");
                System.out.println(e.getMessage());
            }
        }
        return rooms;
    }
}
