/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE352_Cross_Site_Request_Forgery__getParameterServlet_53b.java
Label Definition File: CWE352_Cross_Site_Request_Forgery.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 352 Cross Site Request Forgery
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: using CSRF prevention nonce
 *    BadSink : no CSRF prevention token
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE352_Cross_Site_Request_Forgery;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE352_Cross_Site_Request_Forgery__getParameterServlet_53b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE352_Cross_Site_Request_Forgery__getParameterServlet_53c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE352_Cross_Site_Request_Forgery__getParameterServlet_53c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE352_Cross_Site_Request_Forgery__getParameterServlet_53c()).goodB2G_sink(data , request, response);
    }
}
