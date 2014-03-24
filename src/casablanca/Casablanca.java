package casablanca;

import domain.Controller;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



/**
 *
 * @author hyber
 */
public class Casablanca
{

    public static void main(String[] args)
    {
        Controller con = Controller.getInstance();
        

        String sDate = "26-03-14";
        String eDate = "30-03-14";
        int rSize = 1;
        ArrayList<String> list = con.getAllFreeRooms(sDate, eDate);
        
        for (String string : list)
        {
            System.out.println(string);
        }

        System.out.println("\n\n");
        ArrayList<String> list2 = con.getSizeFreeRooms(sDate, eDate, rSize);
        
        for (String string : list2)
        {
            System.out.println(string);
        }
        
        
        
    }
    
}
