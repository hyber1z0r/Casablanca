/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Booking;
import domain.Bookings_Guests;
import domain.Guest;
import domain.Room;
import domain.TodayGuest;
import domain.Travelagency_guests;
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
                + "(b.start_date <= ? and b.end_date <= ? and b.end_date >= ?)"
                + "or (b.start_date >= ? and b.start_date <= ? and b.end_date >= ?)"
                + "or (b.start_date <= ? and b.end_date >= ?)"
                + "or (b.start_date >= ? and b.end_date <= ?)))"
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
                rooms.add(new Room(rs.getInt(1), rs.getInt(2)));
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
                + "(b.start_date <= ? and b.end_date <= ? and b.end_date >= ?)"
                + "or (b.start_date >= ? and b.start_date <= ? and b.end_date >= ?)"
                + "or (b.start_date <= ? and b.end_date >= ?)"
                + "or (b.start_date >= ? and b.end_date <= ?)))"
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
                rooms.add(new Room(rs.getInt(1), rs.getInt(2)));
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

    public boolean saveNewGuest(Guest g, Connection con)
    {
        int rowsInserted = 0;

        String SQLString1
                = "select guestseq.nextval  "
                + "from dual";

        //ID, FIRSTNAME, FAMILYNAME, ADDRESS, Country, Phone, Email, user, pass
        String SQLString2
                = "insert into guests "
                + "values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;

        try
        {
            con.setAutoCommit(false);
            //== get unique guestId
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                g.setGuest_id(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, g.getGuest_id());
            statement.setString(2, g.getFirstname());
            statement.setString(3, g.getFamilyname());
            statement.setString(4, g.getAddress());
            statement.setString(5, g.getCountry());
            statement.setInt(6, g.getPhone());
            statement.setString(7, g.getEmail());
            statement.setString(8, g.getUsername());
            statement.setString(9, g.getPassword());

            rowsInserted = statement.executeUpdate();
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in roommapper - save new guest rollback");
            }
            System.out.println("Fail in Roommapper - save new guest");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in Roommapper - save new guest");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    public boolean saveNewBooking(Booking b, Connection con)
    {
        int rowsInserted = 0;

        String SQLString1
                = "select bookingseq.nextval  "
                + "from dual";
        // (ID, START_DATE, END_DATE, ROOM_ID, DEPOSIT_PAID, REG_DATE)
        String SQLString2
                = "insert into bookings "
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
                b.setId(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, b.getId());
            statement.setString(2, b.getStart_date());
            statement.setString(3, b.getEnd_date());
            statement.setInt(4, b.getRoom_id());
            statement.setString(5, b.getDeposit_Paid());
            statement.setString(6, b.getReg_date());

            rowsInserted = statement.executeUpdate();
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in Roommapper - rollback save new booking");
            }
            System.out.println("Fail in Roommapper - save new booking");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in Roommapper - save new booking");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    public boolean saveNewBookingsGuests(Bookings_Guests bg, Connection con)
    {
        int rowsInserted = 0;

        String SQLString1
                = "select max(id) from bookings";

        String SQLString2
                = "insert into bookings_guests "
                + "values (?,?)";
        PreparedStatement statement = null;

        try
        {
            con.setAutoCommit(false);
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                bg.setBooking_id(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, bg.getBooking_id());
            statement.setInt(2, bg.getGuest_id());

            rowsInserted = statement.executeUpdate();
            con.commit();
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in Roommapper - rollback save new booking_guests");
            }
            System.out.println("Fail in Roommapper - save new booking_guests");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in Roommapper - close statement save new booking_guests");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    public ArrayList<Booking> getBookedRooms(String type, Connection con)
    {
        ArrayList<Booking> bookings = new ArrayList();
        String SQLdatefix = "alter session set nls_date_format = 'dd-mm-yy'";
        Statement statementFix;

        String SQLString1 = "select * from bookings where deposit_paid = ?";
        PreparedStatement statement = null;

        try
        {
            statementFix = con.createStatement();
            statementFix.execute(SQLdatefix);
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, type);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                String sDate = rs.getString(2);
                String eDate = rs.getString(3);
                String rDate = rs.getString(6);

                String s1 = sDate.substring(8, 10);
                String s2 = sDate.substring(5, 7);
                String s3 = sDate.substring(0, 4);

                String finalSDate = s1 + "-" + s2 + "-" + s3;

                String e1 = eDate.substring(8, 10);
                String e2 = eDate.substring(5, 7);
                String e3 = eDate.substring(0, 4);

                String finalEDate = e1 + "-" + e2 + "-" + e3;

                String r1 = rDate.substring(8, 10);
                String r2 = rDate.substring(5, 7);
                String r3 = rDate.substring(0, 4);

                String finalRDate = r1 + "-" + r2 + "-" + r3;

                bookings.add(new Booking(rs.getInt(1), finalSDate, finalEDate, rs.getInt(4), rs.getString(5), finalRDate));
            }

        } catch (SQLException e)
        {
            System.out.println("Fail in RoomMapper - getBookedRooms");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in RoomMapper.getBookedRooms - Closing statement ");
                System.out.println(e.getMessage());
            }
        }
        return bookings;
    }

    public boolean confirmBooking(Booking b, Connection con)
    {
        int rowsInserted = 0;

        String SQLString2 = "update bookings set deposit_paid = 'yes' where room_id = ? and start_date = ?";
        PreparedStatement statement = null;

        try
        {
            con.setAutoCommit(false);

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, b.getRoom_id());
            statement.setString(2, b.getStart_date());

            rowsInserted = statement.executeUpdate();
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in roommapper - confirm booking rollback");
            }
            System.out.println("Fail in Roommapper - confirm booking");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                con.commit();
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in Roommapper - confirm booking");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    public boolean saveNewTAGUEST(Travelagency_guests tg, Connection con)
    {
        int rowsInserted = 0;

        String SQLString2
                = "insert into travelagency_guests "
                + "values (?,?)";
        PreparedStatement statement = null;

        try
        {
            con.setAutoCommit(false);

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, tg.getTravel_id());
            statement.setInt(2, tg.getGuest_id());

            rowsInserted = statement.executeUpdate();
            con.commit();
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in Roommapper - rollback save new travelagency_guests");
            }
            System.out.println("Fail in Roommapper - save new travelagency_guests");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in Roommapper - close statement save new travelagency_guests");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    public boolean deleteguests(Booking b, Connection con)
    {
        int rowsInserted = 0;
        ArrayList<Integer> guestIDs = new ArrayList();

        String SQLdatefix = "alter session set nls_date_format = 'dd-mm-yy'";
        Statement statementFix;

        String SQLString1 = "select guest_id from bookings_guests where booking_id = (SELECT id FROM bookings where room_id = ? and start_date = ?)";

        String SQLString2
                = "delete from guests where guest_id = ?";
        
        String SQLString3
                = "delete from bookings where id = (SELECT id FROM bookings where room_id = ? and start_date = ?)";
        PreparedStatement statement = null;

        try
        {
            con.setAutoCommit(false);
            statementFix = con.createStatement();
            statementFix.execute(SQLdatefix);
            //== get booking id from room id and start_date
            statement = con.prepareStatement(SQLString1);

            statement.setInt(1, b.getRoom_id());
            statement.setString(2, b.getStart_date());
            ResultSet rs = statement.executeQuery();
            // add the guest ids to arraylist
            while (rs.next())
            {
                guestIDs.add(rs.getInt(1));
            }

            // delete all the guests
            statement = con.prepareStatement(SQLString2);
            for (Integer guestID : guestIDs)
            {
                statement.setInt(1, guestID);
                rowsInserted += statement.executeUpdate();
            }
            
            // delete the booking
            statement = con.prepareStatement(SQLString3);
            statement.setInt(1, b.getRoom_id());
            statement.setString(2, b.getStart_date());
            rowsInserted += statement.executeUpdate();

            con.commit();
        } catch (SQLException e)
        {
            try
            {
                con.rollback();
            } catch (SQLException ex)
            {
                System.out.println("Fail in Roommapper - rollback delete Guests");
            }
            System.out.println("Fail in Roommapper - delete Guests");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in Roommapper - close statement save new travelagency_guests");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == guestIDs.size() + 1;
    }
    
    public ArrayList<TodayGuest> getTodaysGuests(String date, Connection con)
    {
        ArrayList<TodayGuest> guests = new ArrayList();
        String SQLdatefix = "alter session set nls_date_format = 'dd-mm-yy'";
        Statement statementFix;

        String SQLString1 = "SELECT b.room_id, g.FIRSTNAME, g.familyname, g.username, g.password"
                + " FROM BOOKINGS b INNER JOIN BOOKINGS_GUESTS bg"
                + " ON b.ID = bg.BOOKING_ID JOIN GUESTS g"
                + " ON bg.GUEST_ID = g.GUEST_ID"
                + " WHERE b.START_DATE = ?";
        PreparedStatement statement = null;

        try
        {
            statementFix = con.createStatement();
            statementFix.execute(SQLdatefix);
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, date);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                guests.add(new TodayGuest(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }

        } catch (SQLException e)
        {
            System.out.println("Fail in RoomMapper - get Todays Guests");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in RoomMapper.get Todays Guests - Closing statement ");
                System.out.println(e.getMessage());
            }
        }
        return guests;
    }
}
