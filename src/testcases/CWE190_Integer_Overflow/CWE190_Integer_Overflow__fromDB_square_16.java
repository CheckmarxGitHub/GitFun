/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__fromDB_square_16.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: fromDB Read data from a database connection
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: square
*    GoodSink: Ensure there will not be an overflow before performing the squaring operation
*    BadSink : Unchecked squaring operation, which can lead to overflow
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Logger;

import java.lang.Math;

public class CWE190_Integer_Overflow__fromDB_square_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
            break;
        }

        while(true)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
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
            finally
            {
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
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
            int result = (data * data);
            IO.writeLine("result: " + result);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int result = 0;
            /* FIX: Add a check to prevent an overflow from occurring
             * NOTE: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE so we must ensure the random value in
             *       data is not equal to Integer.MIN_VALUE */
            if ((Math.abs(data) != Integer.MIN_VALUE) && (Math.abs(data) <= (int)Math.sqrt(Integer.MAX_VALUE)))
            {
                result = (data * data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform squaring.");
            }
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B() throws Throwable
    {
        int data;
        boolean local_f = false;

        while(true)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
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
            finally
            {
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
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
            int result = (data * data);
            IO.writeLine("result: " + result);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int result = 0;
            /* FIX: Add a check to prevent an overflow from occurring
             * NOTE: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE so we must ensure the random value in
             *       data is not equal to Integer.MIN_VALUE */
            if ((Math.abs(data) != Integer.MIN_VALUE) && (Math.abs(data) <= (int)Math.sqrt(Integer.MAX_VALUE)))
            {
                result = (data * data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform squaring.");
            }
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G() throws Throwable
    {
        int data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
            break;
        }

        while(true)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
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
            finally
            {
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
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
            int result = (data * data);
            IO.writeLine("result: " + result);
            break;
        }

        while(true)
        {
            int result = 0;
            /* FIX: Add a check to prevent an overflow from occurring
             * NOTE: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE so we must ensure the random value in
             *       data is not equal to Integer.MIN_VALUE */
            if ((Math.abs(data) != Integer.MIN_VALUE) && (Math.abs(data) <= (int)Math.sqrt(Integer.MAX_VALUE)))
            {
                result = (data * data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform squaring.");
            }
            break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
