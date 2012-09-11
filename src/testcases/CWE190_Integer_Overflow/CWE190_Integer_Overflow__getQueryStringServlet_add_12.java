/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__getQueryStringServlet_add_12.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: add
*    GoodSink: Ensure there will not be an overflow before performing the addition
*    BadSink : Unchecked addition, which can lead to overflow
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;
import java.sql.*;
import java.io.IOException;

import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__getQueryStringServlet_add_12 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        if(IO.static_returns_t_or_f())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init Data$ */
            data = -1;
            /* parse the query string for value of 'id' */
            String id_str = null;
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                int i = token.indexOf("=");
                if ((i > 0) && (i < (token.length() - 1)) && (token.substring(0, i).equals("id")))
                {
                    id_str = token.substring(i + 1);
                    break;
                }
            }
            if (id_str != null)
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
                    int id = Integer.parseInt(id_str);
                    conn = IO.getDBConnection();
                    statement = conn.prepareStatement("select * from pages where id=?");
                    /* FLAW: no check to see whether the user has privileges to view the data */
                    statement.setInt(1, id);
                    rs = statement.executeQuery();
                    String s_data = rs.toString();
                    data = Integer.parseInt(s_data.trim());
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error");
                }
                finally
                {
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
            }
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_t_or_f())
        {
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        else {

            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too large to perform addition.");
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        if(IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_t_or_f())
        {
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        else {

            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);

            IO.writeLine("result: " + result);

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        if(IO.static_returns_t_or_f())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init Data$ */
            data = -1;
            /* parse the query string for value of 'id' */
            String id_str = null;
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                int i = token.indexOf("=");
                if ((i > 0) && (i < (token.length() - 1)) && (token.substring(0, i).equals("id")))
                {
                    id_str = token.substring(i + 1);
                    break;
                }
            }
            if (id_str != null)
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
                    int id = Integer.parseInt(id_str);
                    conn = IO.getDBConnection();
                    statement = conn.prepareStatement("select * from pages where id=?");
                    /* FLAW: no check to see whether the user has privileges to view the data */
                    statement.setInt(1, id);
                    rs = statement.executeQuery();
                    String s_data = rs.toString();
                    data = Integer.parseInt(s_data.trim());
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error");
                }
                finally
                {
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
            }
        }
        else {

            Logger log_bad = Logger.getLogger("local-logger");

            /* init Data$ */
            data = -1;

            /* parse the query string for value of 'id' */
            String id_str = null;
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                int i = token.indexOf("=");
                if ((i > 0) && (i < (token.length() - 1)) && (token.substring(0, i).equals("id")))
                {
                    id_str = token.substring(i + 1);
                    break;
                }
            }

            if (id_str != null)
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
                    int id = Integer.parseInt(id_str);
                    conn = IO.getDBConnection();
                    statement = conn.prepareStatement("select * from pages where id=?");
                    /* FLAW: no check to see whether the user has privileges to view the data */
                    statement.setInt(1, id);
                    rs = statement.executeQuery();
                    String s_data = rs.toString();
                    data = Integer.parseInt(s_data.trim());
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error");
                }
                finally
                {
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
            }

        }
        if(IO.static_returns_t_or_f())
        {
            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform addition.");
            }
        }
        else {

            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too large to perform addition.");
            }

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
