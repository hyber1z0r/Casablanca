/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Filipovic
 */
public class CreateUserStaff
{

    private String fullName;
    private String userName;
    private String password;

    public CreateUserStaff(String fullName)
    {
        this.fullName = fullName;
        String pre = "CB-";
        String klip = fullName.substring(0, 2);
        int ran = (int) (Math.random() * 500);
        userName = pre + klip + "-" + ran;

        String pre2 = fullName.substring(0, 1);
        int ran2 = (int) (Math.random() * 100 + 100);
        int len = fullName.length();
        char klip2 = fullName.charAt(len - 1);
        password = pre2 + ran2 + klip2;
    }
    

    public String getuserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

}
