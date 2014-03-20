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

    public ArrayList<String> getRooms(String type, Connection con)
    {
        ArrayList<String> rooms = new ArrayList();
        String SQLString1 = "SELECT r.roomnumber, r.roomsize, re.startdate, re.enddate, rs.status "
                + "from Rooms r join RESERVATION re"
                + " on r.ROOMNUMBER = re.ROOMNUMBER JOIN RESERVATIONSTATUS rs"
                + " on re.STATUS = rs.ID"
                + " where rs.status = ?"
                + " order by r.roomnumber";
        PreparedStatement statement = null;

        try
        {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, type);     // primary key value
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
                rooms.add(rs.getInt(1)+ "\t" + rs.getInt(2) + "\t" + rs.getDate(3) + 
                       "\t" + rs.getDate(4) + "\t" + rs.getString(5));
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
