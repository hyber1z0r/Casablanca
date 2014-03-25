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
public class Guest
{
    private int guest_id, phone, travel_agency;
    private String firstname, familyname, address, country, email, username, password;

    public Guest(int guest_id, String firstname, String familyname, String address, 
            String country, int phone, String email, int travel_agency, String username, String password)
    {
        this.guest_id = guest_id;
        this.phone = phone;
        this.travel_agency = travel_agency;
        this.firstname = firstname;
        this.familyname = familyname;
        this.address = address;
        this.country = country;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getGuest_id()
    {
        return guest_id;
    }

    public void setGuest_id(int guest_id)
    {
        this.guest_id = guest_id;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public int getTravel_agency()
    {
        return travel_agency;
    }

    public void setTravel_agency(int travel_agency)
    {
        this.travel_agency = travel_agency;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getFamilyname()
    {
        return familyname;
    }

    public void setFamilyname(String familyname)
    {
        this.familyname = familyname;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    
    
}
