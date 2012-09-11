/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_getCookiesServlet_51b.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-51b.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * BadSink: Servlet querystring parameter not sanitized
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE80_XSS__Servlet_getCookiesServlet_51b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (data != null)
        {
            /* POTENTIAL FLAW: data not validated */
            response.getWriter().println("<br>bad() - Parameter name has value " + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (data != null)
        {
            /* POTENTIAL FLAW: data not validated */
            response.getWriter().println("<br>bad() - Parameter name has value " + data);
        }

    }
}
