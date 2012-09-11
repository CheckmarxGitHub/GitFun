/*
 * @description Improper Resource Shutdown.  Performs some, but not all, necessary resource cleanup (DB connection is not closed).
 * 
 * */

package testcases.CWE404_Improper_Resource_Shutdown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.security.SecureRandom;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE404_Improper_Resource_Shutdown__db_Connection_01 extends
		AbstractTestCase 
{
    private static java.util.logging.Logger log = java.util.logging.Logger.getLogger("local-logger");

	public void bad() throws IOException, SQLException 
	{
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

        try
        {
            int num = (new SecureRandom()).nextInt(200);

            conn = IO.getDBConnection();
            statement = conn.prepareStatement("select * from users where id=?");
            statement.setInt(1, num);
            
            rs = statement.executeQuery();
            
            if (rs.first())
            {
                IO.writeString(rs.toString());
            }
        }
        catch(Exception e)
        {
            log.warning("Error!");
        }
        finally
        {
            try
            {
                if( rs != null )
                {
                    rs.close();
                }
            }
            catch(Exception e)
            {
                log.warning("Error closing rs");
            }
            finally
            {
                try
                {
                    if( statement != null )
                    {
                        statement.close();
                    }
                }
                catch(Exception e)
                {
                    log.warning("Error closing statement");
                }
				
				/* FLAW: DB connection conn is never closed */
            }
        }
	}

	private void good1() throws IOException, SQLException 
	{
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

        try
        {
            int num = (new SecureRandom()).nextInt(200);

            conn = IO.getDBConnection();
            statement = conn.prepareStatement("select * from users where id=?");
            statement.setInt(1, num);
            
            rs = statement.executeQuery();
            
            if (rs.first())
            {
                IO.writeString(rs.toString());
            }
        }
        catch(Exception e)
        {
            log.warning("Error!");
        }
        finally
        {
            try
            {
                if( rs != null )
                {
                    rs.close();
                }
            }
            catch(Exception e)
            {
                log.warning("Error closing rs");
            }
            finally
            {
                try
                {
                    if( statement != null )
                    {
                        statement.close();
                    }
                }
                catch(Exception e)
                {
                    log.warning("Error closing statement");
                }
				
				/* FIX: Close DB connection conn */
				finally
                {
                    try
                    {
                        if (conn != null)
                        {
                            conn.close();
                        }
                    }
                    catch( Exception e )
                    {
                        log.warning("Error closing conn");
                    }
                }
            }
        }
	}
	
	public void good() throws IOException, SQLException 
	{
        good1();
    }
	
	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		mainFromParent(args);
    }
}
