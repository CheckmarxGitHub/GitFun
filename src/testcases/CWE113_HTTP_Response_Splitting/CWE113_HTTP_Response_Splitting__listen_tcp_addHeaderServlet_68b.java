/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__listen_tcp_addHeaderServlet_68b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: addHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addHeader()
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__listen_tcp_addHeaderServlet_68b
{

    public void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE113_HTTP_Response_Splitting__listen_tcp_addHeaderServlet_68a.data;

        /* POTENTIAL FLAW: Input from file not verified */
        response.addHeader("Location", "/author.jsp?lang=" + data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE113_HTTP_Response_Splitting__listen_tcp_addHeaderServlet_68a.data;

        /* POTENTIAL FLAW: Input from file not verified */
        response.addHeader("Location", "/author.jsp?lang=" + data);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE113_HTTP_Response_Splitting__listen_tcp_addHeaderServlet_68a.data;

        /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
        data = URLEncoder.encode(data, "UTF-16");
        response.addHeader("Location", "/author.jsp?lang=" + data);

    }
}
