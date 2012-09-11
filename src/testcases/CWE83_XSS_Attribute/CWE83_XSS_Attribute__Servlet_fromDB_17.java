/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE83_XSS_Attribute__Servlet_fromDB_17.java
Label Definition File: CWE83_XSS_Attribute__Servlet.label.xml
Template File: sources-sink-17.tmpl.java
*/
/*
* @description
* CWE: 83 Cross Site Scripting (XSS) in attributes; Examples(replace QUOTE with an actual double quote): ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEalert(1) and ?img_loc=http://www.google.comQUOTE%20onerror=QUOTEjavascript:alert(1)
* BadSource: fromDB Read a string from a database connection
* GoodSource: A hardcoded string
* BadSink: printlnServlet XSS in img src attribute
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE83_XSS_Attribute;

import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE83_XSS_Attribute__Servlet_fromDB_17 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

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

            data = rs.getString(1);
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
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

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }

        if (data != null)
        {
            /* POTENTIAL FLAW: Input is not verified/sanitized before use in an image tag */
            response.getWriter().println("<br>bad() - <img src=\"" + data + "\">");
        }

    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statement with the one in the for statement */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
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
                data = rs.getString(1);
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
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
        }

        if (data != null)
        {
            /* POTENTIAL FLAW: Input is not verified/sanitized before use in an image tag */
            response.getWriter().println("<br>bad() - <img src=\"" + data + "\">");
        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
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
