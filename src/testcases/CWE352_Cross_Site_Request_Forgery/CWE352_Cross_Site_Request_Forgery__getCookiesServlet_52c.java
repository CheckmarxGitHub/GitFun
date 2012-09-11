/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE352_Cross_Site_Request_Forgery__getCookiesServlet_52c.java
Label Definition File: CWE352_Cross_Site_Request_Forgery.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 352 Cross Site Request Forgery
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: using CSRF prevention nonce
 *    BadSink : no CSRF prevention token
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE352_Cross_Site_Request_Forgery;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE352_Cross_Site_Request_Forgery__getCookiesServlet_52c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FLAW: untrusted input with CSRF prevention mechanism */
        response.getWriter().write(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FLAW: untrusted input with CSRF prevention mechanism */
        response.getWriter().write(data);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* Assuming the presence of a session variable called "token" that contains
             * the nonce value to prevent CSRF */
        /* This testcase is dependent on several others to be a valid weakness:
         *	346 - Origin Validation Error
         *	441 - Unintended Proxy/Intermediary
         *	613 - Insufficient Session Expiration */

        HttpSession session = request.getSession(true);
        String trustedToken = session.getAttribute("token").toString();

        /* FIX: test the value of the request's "token" vs. the session "token" */
        if( request.getParameter("token") == null ||
        !request.getParameter("token").equals(trustedToken) )
        {
            return;
        }

        response.getWriter().write(data);

    }
}
