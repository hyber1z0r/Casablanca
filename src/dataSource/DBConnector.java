package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector
{

    private static final String id = "SEM2_TEST_GR01";
    private static final String pw = "SEM2_TEST_GR01";

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
