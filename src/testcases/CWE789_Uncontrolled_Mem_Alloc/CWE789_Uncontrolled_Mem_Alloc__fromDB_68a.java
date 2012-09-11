/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__fromDB_68a.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: fromDB Read data from a database connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * BadSink: HashMap Create a HashMap using data as the initial size
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE789_Uncontrolled_Mem_Alloc__fromDB_68a extends AbstractTestCase
{

    public static int data;

    public void bad() throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* setup the connection */
            conn = IO.getDBConnection();

            /* prepare the query */
            statement = conn.prepareStatement("select name from users where id=?");

            /* get user input for the userid */
            IO.writeLine("Enter a userid to login as (number): ");
            instrread = new InputStreamReader(System.in);
            buffread = new BufferedReader(instrread);
            int num = Integer.parseInt(buffread.readLine());
            statement.setInt(1, num);
            rs = statement.executeQuery();

            String s_data = rs.getString(1);
            data = Integer.parseInt(s_data.trim());
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }

            /* clean up database objects */
            try {
                if( rs != null )
                {
                    rs.close();
                }
            }
            catch( SQLException se )
            {
                log_bad.warning("Error closing rs");
            }
            finally {
                try {
                    if( statement != null )
                    {
                        statement.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing statement");
                }
                finally {
                    try {
                        if( conn != null )
                        {
                            conn.close();
                        }
                    }
                    catch( SQLException se)
                    {
                        log_bad.warning("Error closing conn");
                    }
                }
            }
        }

        (new CWE789_Uncontrolled_Mem_Alloc__fromDB_68b()).bad_sink();
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        (new CWE789_Uncontrolled_Mem_Alloc__fromDB_68b()).goodG2B_sink();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
