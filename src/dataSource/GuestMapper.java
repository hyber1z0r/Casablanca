/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Facility_Booking;
import domain.Fbooking;
import domain.Fbooking_Guests;
import domain.Guest;
import domain.GuestDates;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

            if (rs.next())
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

    //first save facilitybooking, then fbooking guests, if any fail rollback.
    public boolean saveNewFBooking(Facility_Booking fb, Connection con)
    {
        int rowsInserted = 0;

        String SQLString1
                = "select facilitybseq.nextval  "
                + "from dual";
        // (ID, START_DATE, END_DATE, FID, IID, REG_DATE)
        String SQLString2
                = "insert into facilitybooking "
                + "values (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try
        {
            con.setAutoCommit(false);
            //== get unique bookingId
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                fb.setID(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, fb.getID());
            statement.setString(2, fb.getStart_date());
            statement.setString(3, fb.getEnd_date());
            statement.setInt(4, fb.getFID());
            statement.setInt(5, fb.getIID());
            statement.setString(6, fb.getReg_date());

            rowsInserted = statement.executeUpdate();
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in GuestMapper - rollback save new fbooking");
            }
            System.out.println("Fail in GuestMapper - save new fbooking");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in GuestMapper - save new fbooking");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    public boolean saveNewFBookingsGuests(Fbooking_Guests fbg, Connection con)
    {
        int rowsInserted = 0;

        String SQLString1
                = "select max(id) from faciltybooking";

        String SQLString2
                = "insert into fbookings_guests "
                + "values (?,?)";
        PreparedStatement statement = null;

        try
        {
            con.setAutoCommit(false);
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                fbg.setFID(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, fbg.getFID());
            statement.setInt(2, fbg.getGID());

            rowsInserted = statement.executeUpdate();
            con.commit();
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in GuestMapper - rollback save new fbooking_guests");
            }
            System.out.println("Fail in GuestMapper - save new fbooking_guests");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in GuestMapper - close statement save new fbooking_guests");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    public ArrayList<Fbooking> getFBookings(int gID, Connection con)
    {
        ArrayList<Fbooking> fb = new ArrayList();
        String SQLdatefix = "alter session set nls_date_format = 'dd-mm-yy hh24'";
        Statement statementFix;
        String SQLString = "SELECT f.NAME, f.Courts, to_char(fb.start_date, 'dd-mm-yyyy hh24:mi'), to_char(fb.end_date, 'dd-mm-yyyy hh24:mi')"
                + " FROM FACILITYBOOKING fb INNER JOIN FBOOKING_GUESTS fbg"
                + " ON fb.ID = fbg.FID JOIN FACILITY f"
                + " ON fb.FID = f.ID"
                + " WHERE fbg.GID = ?";

        PreparedStatement statement = null;
        try
        {
            statementFix = con.createStatement();
            statementFix.execute(SQLdatefix);
            //== get tuples
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, gID);

            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                fb.add(new Fbooking(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in GuestMapper - rollback get fbookings");
            }
            System.out.println("Fail in GuestMapper - get fbookings");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in GuestMapper - save new fbooking");
                System.out.println(e.getMessage());
            }
        }
        return fb;

    }

    public ArrayList<GuestDates> getGuestDates(int gID, Connection con)
    {
        ArrayList<GuestDates> gd = new ArrayList();
        String SQLdatefix = "alter session set nls_date_format = 'dd-mm-yyyy'";
        Statement statementFix;
        String SQLString = "SELECT to_char(b.start_date, 'Mon. dd'), to_char(b.end_date, 'Mon. dd')"
                + " from bookings b inner join bookings_guests bg"
                + " on bg.booking_id = b.id join guests g"
                + " on g.guest_id = bg.guest_id"
                + " where g.guest_id = ?";

        PreparedStatement statement = null;
        try
        {
            statementFix = con.createStatement();
            statementFix.execute(SQLdatefix);
            //== get tuples
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, gID);

            ResultSet rs = statement.executeQuery();

            if (rs.next())
            {
                gd.add(new GuestDates(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in GuestMapper - rollback getGuestDates");
            }
            System.out.println("Fail in GuestMapper - getGuestDates");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in GuestMapper - getGuestDates");
                System.out.println(e.getMessage());
            }
        }
        return gd;
    }
    
    public ArrayList<String> getNonFreeDates(String start_date, int FID, Connection con)
    {
        ArrayList<String> freeList = new ArrayList();
        String SQLdatefix = "alter session set nls_date_format = 'dd-mm-yy hh24'";
        Statement statementFix;
        String SQLString = "SELECT to_char(START_DATE, 'hh24:mi') FROM FACILITYBOOKING WHERE START_DATE LIKE ? and FID = ?";

        PreparedStatement statement = null;
        try
        {
            statementFix = con.createStatement();
            statementFix.execute(SQLdatefix);
            //== get tuples
            statement = con.prepareStatement(SQLString);
            statement.setString(1, start_date + "%");
            statement.setInt(2, FID);

            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                freeList.add(rs.getString(1));
            }
        } catch (SQLException e)
        {
            System.out.println("Fail in GuestMapper - getNonFreeDates");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in GuestMapper - getNonFreeDates");
                System.out.println(e.getMessage());
            }
        }
        return freeList;
    }
}