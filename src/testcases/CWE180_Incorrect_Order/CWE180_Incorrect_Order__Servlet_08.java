/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE180_Incorrect_Order__Servlet_08.java
Label Definition File: CWE180_Incorrect_Order__Servlet.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 180 Incorrect Order
* Sinks: incOrderServlet
*    GoodSink: canonicalize before validate
*    BadSink : validate before canonicalize
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE180_Incorrect_Order;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE180_Incorrect_Order__Servlet_08 extends AbstractTestCaseServlet
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_returns_t())
        {
            if (request.getParameter("value") == null)
                return;
            /* POTENTIAL FLAW: Validation before canonicalization */
            if (request.getParameter("value").matches("(blah|blah2)"))
            {
                response.getWriter().println("Invalid value for value");
                return;
            }
            /* POTENTIAL FLAW: canonicalization after validation */
            String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");
            response.getWriter().println("Value is: " + UTF8_value);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (request.getParameter("value") == null)
                return;

            /* FIX: canonicalization before validation */
            String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");

            if (request.getParameter("value").matches("(blah|blah2)"))
            {
                response.getWriter().println("Invalid value for value");
                return;
            }

            response.getWriter().println("Value is: " + UTF8_value);

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (request.getParameter("value") == null)
                return;
            /* POTENTIAL FLAW: Validation before canonicalization */
            if (request.getParameter("value").matches("(blah|blah2)"))
            {
                response.getWriter().println("Invalid value for value");
                return;
            }
            /* POTENTIAL FLAW: canonicalization after validation */
            String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");
            response.getWriter().println("Value is: " + UTF8_value);
        }
        else {

            if (request.getParameter("value") == null)
                return;

            /* FIX: canonicalization before validation */
            String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");

            if (request.getParameter("value").matches("(blah|blah2)"))
            {
                response.getWriter().println("Invalid value for value");
                return;
            }

            response.getWriter().println("Value is: " + UTF8_value);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_t())
        {
            if (request.getParameter("value") == null)
                return;
            /* FIX: canonicalization before validation */
            String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");
            if (request.getParameter("value").matches("(blah|blah2)"))
            {
                response.getWriter().println("Invalid value for value");
                return;
            }
            response.getWriter().println("Value is: " + UTF8_value);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (request.getParameter("value") == null)
                return;

            /* POTENTIAL FLAW: Validation before canonicalization */
            if (request.getParameter("value").matches("(blah|blah2)"))
            {
                response.getWriter().println("Invalid value for value");
                return;
            }

            /* POTENTIAL FLAW: canonicalization after validation */
            String UTF8_value = new String(request.getParameter("value").getBytes("UTF8"), "UTF8");

            response.getWriter().println("Value is: " + UTF8_value);

        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
