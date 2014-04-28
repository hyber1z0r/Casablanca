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
public class Fbooking
{
    private String name, start_date, end_date;
    private int courtno;
    
    public Fbooking(String name, int courtno, String start_date, String end_date)
    {
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.courtno = courtno;
}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public int getCourtno()
    {
        return courtno;
    }

    public void setCourtno(int courtno)
    {
        this.courtno = courtno;
    }
    
    
}
