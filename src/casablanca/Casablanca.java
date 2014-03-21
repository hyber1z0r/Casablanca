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
        

        String sDate = "20-03-2014";
        String eDate = "01-06-2014";
        int rSize = 5;
        ArrayList<String> list = con.getAllFreeRooms(sDate, eDate);
        
        for (String string : list)
        {
            System.out.println(string);
        }
        
//        ArrayList<String> list2 = con.getSizeFreeRooms(sDate, eDate, rSize);
//        
//        for (String string : list2)
//        {
//            System.out.println(string);
//        }
        
        
        
    }
    
}
