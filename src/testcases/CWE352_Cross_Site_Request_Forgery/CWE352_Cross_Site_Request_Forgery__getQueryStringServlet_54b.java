/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE352_Cross_Site_Request_Forgery__getQueryStringServlet_54b.java
Label Definition File: CWE352_Cross_Site_Request_Forgery.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 352 Cross Site Request Forgery
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: using CSRF prevention nonce
 *    BadSink : no CSRF prevention token
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE352_Cross_Site_Request_Forgery;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE352_Cross_Site_Request_Forgery__getQueryStringServlet_54b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE352_Cross_Site_Request_Forgery__getQueryStringServlet_54c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE352_Cross_Site_Request_Forgery__getQueryStringServlet_54c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE352_Cross_Site_Request_Forgery__getQueryStringServlet_54c()).goodB2G_sink(data , request, response);
    }
}
