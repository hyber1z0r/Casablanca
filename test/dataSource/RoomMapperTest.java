/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import domain.Booking;
import domain.Bookings_Guests;
import domain.Controller;
import domain.Guest;
import domain.Room;
import domain.Travelagency_guests;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jakobgaardandersen
 */
//public class RoomMapperTest
//{
//    Connection con;
//    RoomMapper instance;
//    Controller c;
//    
//    public RoomMapperTest()
//    {
//        con = new DBConnector().getConnection();
//        instance = new RoomMapper();
//        c = Controller.getInstance();
//    }
//    
//    
//    @BeforeClass
//    public static void setUpClass()
//    {
//    }
//    
//    @AfterClass
//    public static void tearDownClass()
//    {
//    }
//    
//    @Before
//    public void setUp()
//    {
//        
//    }
//    
//    @After
//    public void tearDown()
//    {
//    }
//
//    /**
//     * Test of getSizeFreeRooms method, of class RoomMapper.
//     */
//    @Test
//    public void testGetSizeFreeRooms()
//    {
//        String sDate = "26-03-14";
//        String eDate = "30-03-14";
//        int rSize = 5;
//        
//        ArrayList<Room> result = instance.getSizeFreeRooms(sDate, eDate, rSize, con);
//        for (Room room : result)
//        {
//            assertEquals(rSize, room.getRoomsize());
//        }
//    }
//
//    /**
//     * Test of saveNewGuest method, of class RoomMapper.
//     */
//    @Test
//    public void testSaveNewGuest()
//    {
//        Guest g = new Guest(999, "Test", "Person", "asd", "asd", 1234, "asd@asdad", 18, "username", "pw");
//        boolean expResult = true;
//        boolean result = instance.saveNewGuest(g, con);
//        assertEquals(expResult, result);
//    }
//
////    /**
////     * Test of saveNewBooking method, of class RoomMapper.
////     */
//    @Test
//    public void testSaveNewBooking()
//    {
//        Booking b = new Booking(123, "24-04-14", "26-04-14", 104, "no", "24-03-14");
//        boolean expResult = true;
//        boolean result = instance.saveNewBooking(b, con);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of saveNewTAGUEST method, of class RoomMapper.
//     */
//    @Test
//    public void testSaveNewTAGUEST()
//    {
//        Travelagency_guests result = c.createNewTAGUEST(1, 999);
//        assertNotNull(result);
//    }
//    
//    @Test
//    public void testSaveNewBookingsGuests()
//    {
//        //if the methods above has been run i will succeed!
//        Bookings_Guests bg = new Bookings_Guests(123, 999);
//        boolean expResult = true;
//        boolean result = instance.saveNewBookingsGuests(bg, con);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getBookedRooms method, of class RoomMapper.
//     */
//    @Test
//    public void testGetBookedRooms()
//    {
//        System.out.println("getBookedRooms");
//        String type = "";
//        Connection con = null;
//        RoomMapper instance = new RoomMapper();
//        ArrayList<Booking> expResult = null;
//        ArrayList<Booking> result = instance.getBookedRooms(type, con);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of confirmBooking method, of class RoomMapper.
//     */
//    @Test
//    public void testConfirmBooking()
//    {
//        System.out.println("confirmBooking");
//        Booking b = null;
//        Connection con = null;
//        RoomMapper instance = new RoomMapper();
//        boolean expResult = false;
//        boolean result = instance.confirmBooking(b, con);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//

//
//    /**
//     * Test of deleteguests method, of class RoomMapper.
//     */
//    @Test
//    public void testDeleteguests()
//    {
//        System.out.println("deleteguests");
//        Booking b = null;
//        Connection con = null;
//        RoomMapper instance = new RoomMapper();
//        boolean expResult = false;
//        boolean result = instance.deleteguests(b, con);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTodaysGuests method, of class RoomMapper.
//     */
//    @Test
//    public void testGetTodaysGuests()
//    {
//        System.out.println("getTodaysGuests");
//        String date = "";
//        Connection con = null;
//        RoomMapper instance = new RoomMapper();
//        ArrayList<TodayGuest> expResult = null;
//        ArrayList<TodayGuest> result = instance.getTodaysGuests(date, con);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of showRegInfo method, of class RoomMapper.
//     */
//    @Test
//    public void testShowRegInfo()
//    {
//        System.out.println("showRegInfo");
//        int room_id = 0;
//        String start_date = "";
//        Connection con = null;
//        RoomMapper instance = new RoomMapper();
//        ArrayList<Guest> expResult = null;
//        ArrayList<Guest> result = instance.showRegInfo(room_id, start_date, con);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateGuest method, of class RoomMapper.
//     */
//    @Test
//    public void testUpdateGuest()
//    {
//        System.out.println("updateGuest");
//        Guest g = null;
//        Connection con = null;
//        RoomMapper instance = new RoomMapper();
//        boolean expResult = false;
//        boolean result = instance.updateGuest(g, con);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of saveNewInstructor method, of class RoomMapper.
//     */
//    @Test
//    public void testSaveNewInstructor()
//    {
//        System.out.println("saveNewInstructor");
//        Instructor i = null;
//        Connection con = null;
//        RoomMapper instance = new RoomMapper();
//        boolean expResult = false;
//        boolean result = instance.saveNewInstructor(i, con);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllInstructors method, of class RoomMapper.
//     */
//    @Test
//    public void testGetAllInstructors()
//    {
//        System.out.println("getAllInstructors");
//        Connection con = null;
//        RoomMapper instance = new RoomMapper();
//        ArrayList<Instructor> expResult = null;
//        ArrayList<Instructor> result = instance.getAllInstructors(con);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteInstructor method, of class RoomMapper.
//     */
//    @Test
//    public void testDeleteInstructor()
//    {
//        System.out.println("deleteInstructor");
//        int id = 0;
//        Connection con = null;
//        RoomMapper instance = new RoomMapper();
//        boolean expResult = false;
//        boolean result = instance.deleteInstructor(id, con);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
