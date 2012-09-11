/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE293_Using_Referer_Field_for_Authentication__Servlet_17.java
Label Definition File: CWE293_Using_Referer_Field_for_Authentication__Servlet.label.xml
Template File: source-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 293 Using Referer Field For Authentication
* BadSource: hardcodedPasswordServlet Data from referer
* Sinks: refererServlet
*    GoodSink: use referer to print data
*    BadSink : use referer in auth decision
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE293_Using_Referer_Field_for_Authentication;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE293_Using_Referer_Field_for_Authentication__Servlet_17 extends AbstractTestCaseServlet
{

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

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* POTENTIAL FLAW: Using Referer header for authentication */
            if(data.equals("http://real.authentication.com/login_success.jsp"))
            {
                /* you're authenticated! */
                response.getWriter().write("You are authenticated!");
                request.getSession(true).setAttribute("authenticated", true);
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use Referer in some other way */
            if (data.equals("http://www.google.com"))
            {
                response.getWriter().write("Welcome Google Searcher!");
            }
        }
    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the for statements */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
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

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            /* FIX: Use Referer in some other way */
            if (data.equals("http://www.google.com"))
            {
                response.getWriter().write("Welcome Google Searcher!");
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodB2G(request, response);
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
