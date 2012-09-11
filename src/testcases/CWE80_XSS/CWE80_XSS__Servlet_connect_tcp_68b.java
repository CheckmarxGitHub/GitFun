/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_connect_tcp_68b.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-68b.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * BadSink: Servlet querystring parameter not sanitized
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

public class CWE80_XSS__Servlet_connect_tcp_68b
{

    public void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE80_XSS__Servlet_connect_tcp_68a.data;

        if (data != null)
        {
            /* POTENTIAL FLAW: data not validated */
            response.getWriter().println("<br>bad() - Parameter name has value " + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE80_XSS__Servlet_connect_tcp_68a.data;

        if (data != null)
        {
            /* POTENTIAL FLAW: data not validated */
            response.getWriter().println("<br>bad() - Parameter name has value " + data);
        }

    }
}
