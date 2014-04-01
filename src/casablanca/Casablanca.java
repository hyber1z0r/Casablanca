package casablanca;

import domain.Controller;
import domain.CreateUserStaff;
import domain.Guest;
import domain.Room;
import java.util.ArrayList;




/**
 *
 * @author hyber
 */
public class Casablanca
{

    public static void main(String[] args)
    {

        String username = "CB-ka-87";
        String password = "k197k";
        Controller con = Controller.getInstance();
        
        boolean status = con.checkLogin(username, password);
        if(status)
        {
            System.out.println("Login successfull");
        }else
        {
            System.out.println("Wrong username/password");
        }
    }
    
}
