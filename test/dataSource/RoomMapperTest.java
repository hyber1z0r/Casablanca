/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import domain.Room;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hyber
 */
public class RoomMapperTest
{
    
    public RoomMapperTest()
    {
    }
    
    @Before
    public void setUp()
    {
    }

  

    @Test
    public void testGetSizeFreeRooms()
    {
        String sDate = "26-03-14";
        String eDate = "30-03-14";
        int rSize = 5;
        Connection con = new DBConnector().getConnection();
        RoomMapper instance = new RoomMapper();
        
        ArrayList<Room> result = instance.getSizeFreeRooms(sDate, eDate, rSize, con);
        for (Room room : result)
        {
            assertEquals(rSize, room.getRoomsize());
        }
        
    }
    
}
