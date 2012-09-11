/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE601_Open_Redirect__Servlet_getCookiesServlet_61b.java
Label Definition File: CWE601_Open_Redirect__Servlet.label.xml
Template File: sources-sink-61b.tmpl.java
*/
/*
 * @description
 * CWE: 601 Open Redirect
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : place redirect string directly into redirect api call
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE601_Open_Redirect;

import testcasesupport.*;

import javax.servlet.http.*;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE601_Open_Redirect__Servlet_getCookiesServlet_61b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            data = cookieSources[0].getValue();
        }
        else
        {
            data = null;
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

}
