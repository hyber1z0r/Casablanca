/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author hyber
 */
public class Booking
{
    private int id;
    private String start_date;
    private String end_date;
    private int room_id;
    private String deposit_Paid;
    private String reg_date;

    public Booking(int id, String start_date, String end_date, int room_id, String deposit_Paid, String reg_date)
    {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.room_id = room_id;
        this.deposit_Paid = deposit_Paid;
        this.reg_date = reg_date;
        
    }

    public String getDeposit_Paid()
    {
        return deposit_Paid;
    }

    public void setDeposit_Paid(String deposit_Paid)
    {
        this.deposit_Paid = deposit_Paid;
    }

    public String getReg_date()
    {
        return reg_date;
    }

    public void setReg_date(String reg_date)
    {
        this.reg_date = reg_date;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStart_date()
    {
        return start_date;
    }

    public void setStart_date(String start_date)
    {
        this.start_date = start_date;
    }

    public String getEnd_date()
    {
        return end_date;
    }

    public void setEnd_date(String end_date)
    {
        this.end_date = end_date;
    }

    public int getRoom_id()
    {
        return room_id;
    }

    public void setRoom_id(int room_id)
    {
        this.room_id = room_id;
    }

   
}
