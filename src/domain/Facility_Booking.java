/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author jakobgaardandersen
 */
public class Facility_Booking
{
    private int ID, FID, IID;
    private String start_date, end_date, reg_date;

    public Facility_Booking(int ID, int FID, int IID, String start_date, String end_date, String reg_date)
    {
        this.ID = ID;
        this.FID = FID;
        this.IID = IID;
        this.start_date = start_date;
        this.end_date = end_date;
        this.reg_date = reg_date;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getFID()
    {
        return FID;
    }

    public void setFID(int FID)
    {
        this.FID = FID;
    }

    public int getIID()
    {
        return IID;
    }

    public void setIID(int IID)
    {
        this.IID = IID;
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

    public String getReg_date()
    {
        return reg_date;
    }

    public void setReg_date(String reg_date)
    {
        this.reg_date = reg_date;
    }
    
    
}
