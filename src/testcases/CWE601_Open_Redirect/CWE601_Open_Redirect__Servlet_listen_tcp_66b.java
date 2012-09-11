/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_listen_tcp_66b.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-66b.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CWE601_Open_Redirect__Servlet_listen_tcp_66b
{

    public void bad_sink(String data_array[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_array[2];

        if (data != null)
        {
            /* This prevents \r\n (and other chars) and should prevent incidentals such
             * as HTTP Response Splitting and HTTP Header Injection.
            */
            URI u;
            try
            {
                u = new URI(data);
            }
            catch (URISyntaxException e)
            {
                response.getWriter().write("Invalid redirect URL");
                return;
            }
            /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
            response.sendRedirect(data);
            return;
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data_array[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_array[2];

        if (data != null)
        {
            /* This prevents \r\n (and other chars) and should prevent incidentals such
             * as HTTP Response Splitting and HTTP Header Injection.
            */
            URI u;
            try
            {
                u = new URI(data);
            }
            catch (URISyntaxException e)
            {
                response.getWriter().write("Invalid redirect URL");
                return;
            }
            /* POTENTIAL FLAW: redirect is sent verbatim; escape the string to prevent ancillary issues like XSS, Response splitting etc */
            response.sendRedirect(data);
            return;
        }

    }

}
