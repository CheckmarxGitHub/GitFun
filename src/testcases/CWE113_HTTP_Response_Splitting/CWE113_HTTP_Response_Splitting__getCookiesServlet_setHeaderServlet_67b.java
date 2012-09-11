/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getCookiesServlet_setHeaderServlet_67b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks: setHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to setHeader()
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__getCookiesServlet_setHeaderServlet_67b
{

    public void bad_sink(CWE113_HTTP_Response_Splitting__getCookiesServlet_setHeaderServlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        /* POTENTIAL FLAW: Input not verified before inclusion in header */
        response.setHeader("Location", "/author.jsp?lang=" + data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE113_HTTP_Response_Splitting__getCookiesServlet_setHeaderServlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        /* POTENTIAL FLAW: Input not verified before inclusion in header */
        response.setHeader("Location", "/author.jsp?lang=" + data);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE113_HTTP_Response_Splitting__getCookiesServlet_setHeaderServlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
        data = URLEncoder.encode(data, "UTF-16");
        response.setHeader("Location", "/author.jsp?lang=" + data);

    }
}
