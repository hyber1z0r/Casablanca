/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;


import domain.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hyber
 */
public class RoomMapper
{

    public ArrayList<Room> getAllFreeRooms(String sDate, String eDate, Connection con)
    {
        ArrayList<Room> rooms = new ArrayList();
        String SQLdatefix = "alter session set nls_date_format = 'dd-mm-yy'";
        Statement statementFix;
        
        String SQLString1 = "SELECT * FROM ROOMS r where room_id not in ("
                + "SELECT ROOM_ID FROM BOOKINGS b where ("
                + "(b.start_date < ? and b.end_date < ? and b.end_date > ?)"
                + "or (b.start_date > ? and b.start_date < ? and b.end_date > ?)"
                + "or (b.start_date < ? and b.end_date > ?)"
                + "or (b.start_date > ? and b.end_date < ?)))"
                + "order by room_id";
        PreparedStatement statement = null;
        

        try
        {
            statementFix = con.createStatement();
            statementFix.execute(SQLdatefix);
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, sDate);
            statement.setString(2, eDate);
            statement.setString(3, sDate);
            statement.setString(4, sDate);
            statement.setString(5, eDate);
            statement.setString(6, eDate);
            statement.setString(7, sDate);
            statement.setString(8, eDate);
            statement.setString(9, sDate);
            statement.setString(10, eDate);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
                rooms.add(new Room(rs.getInt(1),rs.getInt(2)));
            }

        } catch (SQLException e)
        {
            System.out.println("Fail in RoomMapper - getAllRooms");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in RoomMapper.getAllFreeRooms - Closing statement ");
                System.out.println(e.getMessage());
            }
        }
        return rooms;
    }
     public ArrayList<Room> getSizeFreeRooms(String sDate, String eDate, int rSize, Connection con)
    {
        ArrayList<Room> rooms = new ArrayList();
        String SQLdatefix = "alter session set nls_date_format = 'dd-mm-yy'";
        Statement statementFix;
        String SQLString1 = "SELECT * FROM ROOMS r where room_size = ? and room_id not in ("
                + "SELECT ROOM_ID FROM BOOKINGS b where ("
                + "(b.start_date < ? and b.end_date < ? and b.end_date > ?)"
                + "or (b.start_date > ? and b.start_date < ? and b.end_date > ?)"
                + "or (b.start_date < ? and b.end_date > ?)"
                + "or (b.start_date > ? and b.end_date < ?)))"
                + "order by room_id";
        PreparedStatement statement = null;

        try
        {
            statementFix = con.createStatement();
            statementFix.execute(SQLdatefix);
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, rSize);
            statement.setString(2, sDate);
            statement.setString(3, eDate);
            statement.setString(4, sDate);
            statement.setString(5, sDate);
            statement.setString(6, eDate);
            statement.setString(7, eDate);
            statement.setString(8, sDate);
            statement.setString(9, eDate);
            statement.setString(10, sDate);
            statement.setString(11, eDate);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
                rooms.add(new Room(rs.getInt(1),rs.getInt(2)));
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
