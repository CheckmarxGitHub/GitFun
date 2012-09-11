/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_listen_tcp_54c.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-54c.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: Servlet
 *    BadSink : querystring parameter not sanitized
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE80_XSS__Servlet_listen_tcp_54c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE80_XSS__Servlet_listen_tcp_54d()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE80_XSS__Servlet_listen_tcp_54d()).goodG2B_sink(data , request, response);
    }

}
