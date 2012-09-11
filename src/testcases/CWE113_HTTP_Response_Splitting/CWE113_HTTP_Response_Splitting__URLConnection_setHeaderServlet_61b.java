/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__URLConnection_setHeaderServlet_61b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: URLConnection Read a string from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: setHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to setHeader()
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Logger;

public class CWE113_HTTP_Response_Splitting__URLConnection_setHeaderServlet_61b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public String goodG2B_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public String goodB2G_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        return data;
    }
}