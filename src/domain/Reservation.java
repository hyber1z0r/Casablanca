/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Neno
 */
public class Reservation
{
    private int number;
    private String startdate;
    private String enddate;
    private int status;
    
    public Reservation(int n, String sd, String ed, int s)
    {
        number = n;
        startdate = sd;
        enddate = ed;
        status = s;
        
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getStartdate()
    {
        return startdate;
    }

    public void setStartdate(String startdate)
    {
        this.startdate = startdate;
    }

    public String getEnddate()
    {
        return enddate;
    }

    public void setEnddate(String enddate)
    {
        this.enddate = enddate;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public String toString()
    {
        return number + " " + startdate + " " + enddate + " " + status;
    }
    
}
