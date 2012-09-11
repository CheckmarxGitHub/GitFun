/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_URLConnection_67a.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 257 Storing passwords in a recoverable format
 * BadSource: URLConnection Read a string from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: one-way hash instead of symmetric crypto
 *    BadSink : symmetric encryption with an easy key
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE257_Storing_Password_Recoverable_Format;

import testcasesupport.*;

import java.sql.*;
import java.io.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Logger;

public class CWE257_Storing_Password_Recoverable_Format__Servlet_URLConnection_67a extends AbstractTestCaseServlet
{

    static class Container
    {
        public String a;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        URLConnection conn = (new URL("http://www.example.org/")).openConnection();
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* read input from URLConnection */
            instrread = new InputStreamReader(conn.getInputStream());
            buffread = new BufferedReader(instrread);

            data = buffread.readLine(); // This will be reading the first "line" of the response body,
            // which could be very long if there are no newlines in the HTML
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
        }

        Container data_container = new Container();
        data_container.a = data;
        (new CWE257_Storing_Password_Recoverable_Format__Servlet_URLConnection_67b()).bad_sink(data_container , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        Container data_container = new Container();
        data_container.a = data;
        (new CWE257_Storing_Password_Recoverable_Format__Servlet_URLConnection_67b()).goodG2B_sink(data_container , request, response );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        URLConnection conn = (new URL("http://www.example.org/")).openConnection();
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* read input from URLConnection */
            instrread = new InputStreamReader(conn.getInputStream());
            buffread = new BufferedReader(instrread);

            data = buffread.readLine(); // This will be reading the first "line" of the response body,
            // which could be very long if there are no newlines in the HTML
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
        }

        Container data_container = new Container();
        data_container.a = data;
        (new CWE257_Storing_Password_Recoverable_Format__Servlet_URLConnection_67b()).goodB2G_sink(data_container , request, response );
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
