package casablanca;

import domain.Controller;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author hyber
 */
public class Casablanca
{

    public static void main(String[] args)
    {
        Controller con = Controller.getInstance();
        
        ArrayList<String> freelist = con.getRooms("Free");
   
        
        for (String string : freelist)
        {
            System.out.println(string);
        }
        
        
        
    }
    
}
