package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Encapsulates code to connect to DB
//hau
public class DBConnector
{

    private static final String id = "cphja130";	//Insert ORACLE id and password
    private static final String pw = "cphja130";

    public Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", id, pw);
        } catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }

    public void releaseConnection(Connection con)
    {
        try
        {
            con.close();
        } catch (SQLException e)
        {
            System.err.println(e);
        }
    }
}
