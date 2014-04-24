///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package dataSource;
//
//import domain.Facility_Booking;
//import domain.Guest;
//import domain.Room;
//import java.sql.Connection;
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Neno
// */
//public class GuestMapperTest
//{
//    private Guest g;
//    
//    public GuestMapperTest()
//    {
//    }
//    
//    @Before
//    public void setUp()
//    {
//    }
//    
//    @After
//    public void tearDown()
//    {
//    }
//
//    @Test
//    public void testCheckLogin()
//    {
//        String username = "test1";
//        String password = "test1";
//        Connection con = new DBConnector().getConnection();
//        GuestMapper instance = new GuestMapper();
//        g = new Guest(1, "Jakob", "Andersen", "Ramsøvejen 27", "Denmark",
//                29881727, "Jakob@hotmail.com", 20, "test1", "test1");
//        
//        Guest result = instance.checkLogin(username, password, con);
//        assertTrue(g.getUsername().equals(result.getUsername()) && g.getPassword().equals(result.getPassword()));
//        
//    }
//
//    @Test
//    public void testSaveNewFBooking()
//    {
//        Connection con = new DBConnector().getConnection();
//        GuestMapper instance = new GuestMapper();
//        //f = new Facility_Booking();
//        
//        instance.saveNewFBooking(null, con);
//        
//    }
//
//    @Test
//    public void testSaveNewFBookingsGuests()
//    {
//    }
//
//    @Test
//    public void testGetFBookings()
//    {
//    }
//
//    @Test
//    public void testGetGuestDates()
//    {
//    }
//
//    @Test
//    public void testGetNonFreeDates()
//    {
//    }
//
//    @Test
//    public void testGetNonFreeDatesIns()
//    {
//    }
//
//    @Test
//    public void testDeleteFbooking()
//    {
//    }
//
//    @Test
//    public void testGetInstructor()
//    {
//    }
//
//    @Test
//    public void testGetBookingCount()
//    {
//    }
//
//    @Test
//    public void testGetGuestFBookings()
//    {
//    }
//}