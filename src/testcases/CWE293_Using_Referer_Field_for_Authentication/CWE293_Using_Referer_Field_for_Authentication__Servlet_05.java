/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE293_Using_Referer_Field_for_Authentication__Servlet_05.java
Label Definition File: CWE293_Using_Referer_Field_for_Authentication__Servlet.label.xml
Template File: source-sinks-05.tmpl.java
*/
/*
* @description
* CWE: 293 Using Referer Field For Authentication
* BadSource: hardcodedPasswordServlet Data from referer
* Sinks: refererServlet
*    GoodSink: use referer to print data
*    BadSink : use referer in auth decision
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE293_Using_Referer_Field_for_Authentication;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE293_Using_Referer_Field_for_Authentication__Servlet_05 extends AbstractTestCaseServlet
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if (request.getHeader("Referer") == null)
        {
            response.getWriter().write("Referer not set");
            data = "";
        }
        else {
            data = request.getHeader("Referer");
        }

        if (private_t)
        {
            /* POTENTIAL FLAW: Using Referer header for authentication */
            if(data.equals("http://real.authentication.com/login_success.jsp"))
            {
                /* you're authenticated! */
                response.getWriter().write("You are authenticated!");
                request.getSession(true).setAttribute("authenticated", true);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use Referer in some other way */
            if (data.equals("http://www.google.com"))
            {
                response.getWriter().write("Welcome Google Searcher!");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing private_t to private_f */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if (request.getHeader("Referer") == null)
        {
            response.getWriter().write("Referer not set");
            data = "";
        }
        else {
            data = request.getHeader("Referer");
        }

        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Using Referer header for authentication */
            if(data.equals("http://real.authentication.com/login_success.jsp"))
            {
                /* you're authenticated! */
                response.getWriter().write("You are authenticated!");
                request.getSession(true).setAttribute("authenticated", true);
            }
        }
        else {

            /* FIX: Use Referer in some other way */
            if (data.equals("http://www.google.com"))
            {
                response.getWriter().write("Welcome Google Searcher!");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if (request.getHeader("Referer") == null)
        {
            response.getWriter().write("Referer not set");
            data = "";
        }
        else {
            data = request.getHeader("Referer");
        }

        if(private_t)
        {
            /* FIX: Use Referer in some other way */
            if (data.equals("http://www.google.com"))
            {
                response.getWriter().write("Welcome Google Searcher!");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Using Referer header for authentication */
            if(data.equals("http://real.authentication.com/login_success.jsp"))
            {
                /* you're authenticated! */
                response.getWriter().write("You are authenticated!");
                request.getSession(true).setAttribute("authenticated", true);
            }

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodB2G1(request, response);
        goodB2G2(request, response);
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
