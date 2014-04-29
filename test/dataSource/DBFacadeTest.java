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
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jakobgaardandersen
 */
public class DBFacadeTest
{

    DBFacade facade;
    RoomMapperMock om;

    public DBFacadeTest()
    {
        om = new RoomMapperMock();
        facade = new DBFacade(om);
    }

    @Before
    public void setUp()
    {

        // guests
        Map<Integer, Guest> guests = new HashMap();
        Guest g1 = new Guest(1, "Jakob", "Karlsen", "Gurlivej 27, 4000 Roskilde", "Denmark", 1239193, "jakob@hotmail.dk", 20, "jakobuser", "jakobpass");
        guests.put(1, g1);
        Guest g2 = new Guest(2, "Anders", "Jakobsen", "Ramsøvejen 27, 4132 Hedehusene", "Denmark", 3210303, "andersekaka@hotmail.dk", 23, "andersuser", "anderspass");
        guests.put(2, g2);
        om.setGuests(guests);

        // bookings
        Map<Integer, Booking> bookings = new HashMap();
        Booking b1 = new Booking(1, "26-06-14", "30-06-14", 30, "no", "29-04-14");
        bookings.put(1, b1);
        Booking b2 = new Booking(2, "16-07-14", "21-07-14", 14, "yes", "24-04-14");
        bookings.put(2, b2);
        om.setBookings(bookings);

        // instructors
        Map<Integer, Instructor> ins = new HashMap();
        Instructor i1 = new Instructor(1, "Hans", "Larsen", "hanslarsen@hotmail.com", 22993312, "Tennis");
        Instructor i2 = new Instructor(2, "Lars", "Hansen", "larsabc123@hotmail.dk", 828381, "Swimming");
        ins.put(1, i1);
        ins.put(2, i2);
        om.setInstructors(ins);
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
    }

    /**
     * Test of getSizeFreeRooms method, of class DBFacade.
     */
    @Test
    public void testGetSizeFreeRooms()
    {

    }

    /**
     * Test of saveNewGuest method, of class DBFacade.
     */
    @Test
    public void testSaveNewGuest()
    {
        Guest g1 = new Guest(3, "Didrik", "Poulsen", "Gurlevej 12, 4622 Havdrup", "Denmark", 12313213, "asddd@gmail.dk", 20, "didrikuser", "didsdripass");
        boolean status = facade.saveNewGuest(g1);
        assertTrue(status);
    }

    /**
     * Test of saveNewBooking method, of class DBFacade.
     */
    @Test
    public void testSaveNewBooking()
    {
        Booking b1 = new Booking(3, "26-06-14", "30-06-14", 30, "no", "29-03-14");
        Booking b2 = new Booking(4, "16-07-14", "21-07-14", 14, "no", "24-03-14");
        boolean status = facade.saveNewBooking(b1);
        boolean status2 = facade.saveNewBooking(b2);
        assertTrue(status);
        assertTrue(status2);

    }

    /**
     * Test of saveNewBookingsGuests method, of class DBFacade.
     */
    @Test
    public void testSaveNewBookingsGuests()
    {
        Bookings_Guests bg = new Bookings_Guests(1, 1);
        boolean status = facade.saveNewBookingsGuests(bg);
        assertTrue(status);

    }

    /**
     * Test of getBookedRooms method, of class DBFacade.
     */
    @Test
    public void testGetBookedRooms()
    {
        // bookings indsat i toppen ^
        String paid = "yes";
        String unpaid = "no";
        // relying on confirm booking!
        Map<Integer, Booking> bookings = om.getAllBookings();
        Booking b = bookings.get(2);
        boolean status = facade.confirmBooking(b);

        ArrayList<Booking> paidList = facade.getBookedRooms(paid);
        ArrayList<Booking> unpaidList = facade.getBookedRooms(unpaid);

        for (Booking booking : paidList)
        {
            assertTrue(booking.getId() == 2);
        }

        for (Booking booking : unpaidList)
        {
            assertTrue(booking.getId() == 1);
        }

    }

    /**
     * Test of confirmBooking method, of class DBFacade.
     */
    @Test
    public void testConfirmBooking()
    {
        Map<Integer, Booking> bookings = om.getAllBookings();
        Booking b = bookings.get(1);
        boolean status = facade.confirmBooking(b);
        assertTrue(status);

        Map<Integer, Booking> confirmedbookings = om.getAllConfirmedBookings();

        for (Booking booking : confirmedbookings.values())
        {
            if (booking.getId() == b.getId())
            {
                assertEquals(booking, b);
            }
        }

        Map<Integer, Booking> bookingsDel = om.getAllBookings();

        for (Booking books : bookingsDel.values())
        {
            assertNotSame(b, books);
        }

    }

    /**
     * Test of saveNewTAGUEST method, of class DBFacade.
     */
    @Test
    public void testSaveNewTAGUEST()
    {
        Travelagency_guests tg = new Travelagency_guests(1, 1);
        Travelagency_guests tg2 = new Travelagency_guests(1, 2);
        boolean status = facade.saveNewTAGUEST(tg);
        assertTrue(status);
        boolean status2 = facade.saveNewTAGUEST(tg2);
        assertTrue(status2);
    }

    /**
     * Test of deleteGuest method, of class DBFacade.
     */
    @Test
    public void testDeleteGuest()
    {

    }

    /**
     * Test of getTodaysGuests method, of class DBFacade.
     */
    @Test
    public void testGetTodaysGuests()
    {

    }

    /**
     * Test of showRegInfo method, of class DBFacade.
     */
    @Test
    public void testShowRegInfo()
    {

    }

    /**
     * Test of checkLogin method, of class DBFacade.
     */
    @Test
    public void testCheckLogin()
    {

    }

    /**
     * Test of updateguest method, of class DBFacade.
     */
    @Test
    public void testUpdateguest()
    {
        Map<Integer, Guest> guests = om.getAllGuests();
        Guest g = guests.get(1);
        String nameBefore = g.getFirstname();
        String newName = "Kurt";
        g.setFirstname(newName);
        facade.updateguest(g);

        Map<Integer, Guest> guestsUp = om.getAllGuests();

        for (Guest guest : guestsUp.values())
        {
            if (guest.getGuest_id() == g.getGuest_id())
            {
                assertTrue(guest.getFirstname().equals(newName));
            }
        }

    }

    /**
     * Test of saveNewInstructor method, of class DBFacade.
     */
    @Test
    public void testSaveNewInstructor()
    {
        Instructor in = new Instructor(3, "Test", "person", "test@email.com", 1234567, "Golf");
        facade.saveNewInstructor(in);
        ArrayList<Instructor> ins = om.getAllInstructors();

        Instructor newest = ins.get(ins.size() - 1);
        assertEquals(newest, in);
    }

    /**
     * Test of getAllInstructors method, of class DBFacade.
     */
    @Test
    public void testGetAllInstructors()
    {
        ArrayList<Instructor> ins = facade.getAllInstructors();
        int expected1 = 1;
        int expected2 = 2;

        Instructor i1 = ins.get(0);
        Instructor i2 = ins.get(1);

        assertEquals(i1.getID(), expected1);
        assertEquals(i2.getID(), expected2);
    }

    /**
     * Test of deleteInstructor method, of class DBFacade.
     */
    @Test
    public void testDeleteInstructor()
    {
        // check at det er den rigtige der er slettet
        ArrayList<Instructor> ins = facade.getAllInstructors();
        int id = ins.get(0).getID();

        facade.deleteInstructor(id);

        ArrayList<Instructor> ins2 = facade.getAllInstructors();

        for (Instructor i : ins2)
        {
            assertFalse(i.getID() == id);
        }

    }

    /**
     * Test of saveNewFBooking method, of class DBFacade.
     */
    @Test
    public void testSaveNewFBooking()
    {

    }

    /**
     * Test of saveNewFBookingGuests method, of class DBFacade.
     */
    @Test
    public void testSaveNewFBookingGuests()
    {

    }

    /**
     * Test of getFbookings method, of class DBFacade.
     */
    @Test
    public void testGetFbookings()
    {

    }

    /**
     * Test of getGuestDates method, of class DBFacade.
     */
    @Test
    public void testGetGuestDates()
    {

    }

    /**
     * Test of getNonFreeDates method, of class DBFacade.
     */
    @Test
    public void testGetNonFreeDates()
    {

    }

    /**
     * Test of getNonFreeDatesIns method, of class DBFacade.
     */
    @Test
    public void testGetNonFreeDatesIns()
    {

    }

    /**
     * Test of deleteFbooking method, of class DBFacade.
     */
    @Test
    public void testDeleteFbooking()
    {

    }

    /**
     * Test of getInstructor method, of class DBFacade.
     */
    @Test
    public void testGetInstructor()
    {

    }

    /**
     * Test of getBookingCount method, of class DBFacade.
     */
    @Test
    public void testGetBookingCount()
    {

    }

    /**
     * Test of getGuestFBookings method, of class DBFacade.
     */
    @Test
    public void testGetGuestFBookings()
    {

    }

}
