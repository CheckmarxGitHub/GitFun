/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getCookiesServlet_addCookieServlet_67b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks: addCookieServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addCookie()
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__getCookiesServlet_addCookieServlet_67b
{

    public void bad_sink(CWE113_HTTP_Response_Splitting__getCookiesServlet_addCookieServlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        Cookie cookieSink = new Cookie("lang", data);
        /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
        response.addCookie(cookieSink);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE113_HTTP_Response_Splitting__getCookiesServlet_addCookieServlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        Cookie cookieSink = new Cookie("lang", data);
        /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
        response.addCookie(cookieSink);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE113_HTTP_Response_Splitting__getCookiesServlet_addCookieServlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-16"));
        /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
        response.addCookie(cookieSink);

    }
}
