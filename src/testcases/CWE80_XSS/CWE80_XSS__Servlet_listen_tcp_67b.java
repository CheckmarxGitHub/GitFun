/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_listen_tcp_67b.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-67b.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: Servlet
 *    BadSink : querystring parameter not sanitized
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE80_XSS__Servlet_listen_tcp_67b
{

    public void bad_sink(CWE80_XSS__Servlet_listen_tcp_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        if (data != null)
        {
            /* POTENTIAL FLAW: data not validated */
            response.getWriter().println("<br>bad() - Parameter name has value " + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE80_XSS__Servlet_listen_tcp_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        if (data != null)
        {
            /* POTENTIAL FLAW: data not validated */
            response.getWriter().println("<br>bad() - Parameter name has value " + data);
        }

    }

}
