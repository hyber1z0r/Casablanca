/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import Mocks.RoomMapperMock;
import domain.Booking;
import domain.Bookings_Guests;
import domain.Facility_Booking;
import domain.Fbooking;
import domain.Fbooking_Guests;
import domain.Guest;
import domain.GuestDates;
import domain.Instructor;
import domain.Room;
import domain.TodayGuest;
import domain.Travelagency_guests;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
public class DBFacadeTest
{
    DBFacade facade;
    
    public DBFacadeTest()
    {
    }
    
    @Before
    public void setUp()
    {
        RoomMapperMock om = new RoomMapperMock();
        facade = new DBFacade(om);
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getAllFreeRooms method, of class DBFacade.
     */
    @Test
    public void testGetAllFreeRooms()
    {
        System.out.println("getAllFreeRooms");
        String sDate = "";
        String eDate = "";
        DBFacade instance = new DBFacade();
        ArrayList<Room> expResult = null;
        ArrayList<Room> result = instance.getAllFreeRooms(sDate, eDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSizeFreeRooms method, of class DBFacade.
     */
    @Test
    public void testGetSizeFreeRooms()
    {
        System.out.println("getSizeFreeRooms");
        String sDate = "";
        String eDate = "";
        int rSize = 0;
        DBFacade instance = new DBFacade();
        ArrayList<Room> expResult = null;
        ArrayList<Room> result = instance.getSizeFreeRooms(sDate, eDate, rSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewGuest method, of class DBFacade.
     */
    @Test
    public void testSaveNewGuest()
    {
        System.out.println("saveNewGuest");
        Guest g = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveNewGuest(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewBooking method, of class DBFacade.
     */
    @Test
    public void testSaveNewBooking()
    {
        System.out.println("saveNewBooking");
        Booking b = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveNewBooking(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewBookingsGuests method, of class DBFacade.
     */
    @Test
    public void testSaveNewBookingsGuests()
    {
        System.out.println("saveNewBookingsGuests");
        Bookings_Guests bg = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveNewBookingsGuests(bg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookedRooms method, of class DBFacade.
     */
    @Test
    public void testGetBookedRooms()
    {
        System.out.println("getBookedRooms");
        String type = "";
        DBFacade instance = new DBFacade();
        ArrayList<Booking> expResult = null;
        ArrayList<Booking> result = instance.getBookedRooms(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmBooking method, of class DBFacade.
     */
    @Test
    public void testConfirmBooking()
    {
        System.out.println("confirmBooking");
        Booking b = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.confirmBooking(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewTAGUEST method, of class DBFacade.
     */
    @Test
    public void testSaveNewTAGUEST()
    {
        System.out.println("saveNewTAGUEST");
        Travelagency_guests tg = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveNewTAGUEST(tg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGuest method, of class DBFacade.
     */
    @Test
    public void testDeleteGuest()
    {
        System.out.println("deleteGuest");
        Booking b = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.deleteGuest(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTodaysGuests method, of class DBFacade.
     */
    @Test
    public void testGetTodaysGuests()
    {
        System.out.println("getTodaysGuests");
        String date = "";
        DBFacade instance = new DBFacade();
        ArrayList<TodayGuest> expResult = null;
        ArrayList<TodayGuest> result = instance.getTodaysGuests(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showRegInfo method, of class DBFacade.
     */
    @Test
    public void testShowRegInfo()
    {
        System.out.println("showRegInfo");
        int room_id = 0;
        String start_date = "";
        DBFacade instance = new DBFacade();
        ArrayList<Guest> expResult = null;
        ArrayList<Guest> result = instance.showRegInfo(room_id, start_date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class DBFacade.
     */
    @Test
    public void testCheckLogin()
    {
        System.out.println("checkLogin");
        String username = "";
        String password = "";
        DBFacade instance = new DBFacade();
        Guest expResult = null;
        Guest result = instance.checkLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateguest method, of class DBFacade.
     */
    @Test
    public void testUpdateguest()
    {
        System.out.println("updateguest");
        Guest g = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.updateguest(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewInstructor method, of class DBFacade.
     */
    @Test
    public void testSaveNewInstructor()
    {
        System.out.println("saveNewInstructor");
        Instructor i = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveNewInstructor(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllInstructors method, of class DBFacade.
     */
    @Test
    public void testGetAllInstructors()
    {
        System.out.println("getAllInstructors");
        DBFacade instance = new DBFacade();
        ArrayList<Instructor> expResult = null;
        ArrayList<Instructor> result = instance.getAllInstructors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteInstructor method, of class DBFacade.
     */
    @Test
    public void testDeleteInstructor()
    {
        System.out.println("deleteInstructor");
        int id = 0;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.deleteInstructor(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewFBooking method, of class DBFacade.
     */
    @Test
    public void testSaveNewFBooking()
    {
        System.out.println("saveNewFBooking");
        Facility_Booking fb = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveNewFBooking(fb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewFBookingGuests method, of class DBFacade.
     */
    @Test
    public void testSaveNewFBookingGuests()
    {
        System.out.println("saveNewFBookingGuests");
        Fbooking_Guests fbg = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveNewFBookingGuests(fbg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFbookings method, of class DBFacade.
     */
    @Test
    public void testGetFbookings()
    {
        System.out.println("getFbookings");
        int gID = 0;
        DBFacade instance = new DBFacade();
        ArrayList<Fbooking> expResult = null;
        ArrayList<Fbooking> result = instance.getFbookings(gID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuestDates method, of class DBFacade.
     */
    @Test
    public void testGetGuestDates()
    {
        System.out.println("getGuestDates");
        int gID = 0;
        DBFacade instance = new DBFacade();
        ArrayList<GuestDates> expResult = null;
        ArrayList<GuestDates> result = instance.getGuestDates(gID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNonFreeDates method, of class DBFacade.
     */
    @Test
    public void testGetNonFreeDates()
    {
        System.out.println("getNonFreeDates");
        String start_date = "";
        int FID = 0;
        DBFacade instance = new DBFacade();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getNonFreeDates(start_date, FID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNonFreeDatesIns method, of class DBFacade.
     */
    @Test
    public void testGetNonFreeDatesIns()
    {
        System.out.println("getNonFreeDatesIns");
        String start_date = "";
        int FID = 0;
        DBFacade instance = new DBFacade();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getNonFreeDatesIns(start_date, FID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFbooking method, of class DBFacade.
     */
    @Test
    public void testDeleteFbooking()
    {
        System.out.println("deleteFbooking");
        String start_date = "";
        int FID = 0;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.deleteFbooking(start_date, FID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstructor method, of class DBFacade.
     */
    @Test
    public void testGetInstructor()
    {
        System.out.println("getInstructor");
        String facility = "";
        DBFacade instance = new DBFacade();
        Instructor expResult = null;
        Instructor result = instance.getInstructor(facility);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingCount method, of class DBFacade.
     */
    @Test
    public void testGetBookingCount()
    {
        System.out.println("getBookingCount");
        int GID = 0;
        String start_date = "";
        DBFacade instance = new DBFacade();
        int expResult = 0;
        int result = instance.getBookingCount(GID, start_date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuestFBookings method, of class DBFacade.
     */
    @Test
    public void testGetGuestFBookings()
    {
        System.out.println("getGuestFBookings");
        int GID = 0;
        String start_date = "";
        DBFacade instance = new DBFacade();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getGuestFBookings(GID, start_date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
