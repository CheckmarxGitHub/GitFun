/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__console_readLine_addHeaderServlet_54b.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded string
 * Sinks: addHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addHeader()
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__console_readLine_addHeaderServlet_54b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE113_HTTP_Response_Splitting__console_readLine_addHeaderServlet_54c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE113_HTTP_Response_Splitting__console_readLine_addHeaderServlet_54c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE113_HTTP_Response_Splitting__console_readLine_addHeaderServlet_54c()).goodB2G_sink(data , request, response);
    }
}
