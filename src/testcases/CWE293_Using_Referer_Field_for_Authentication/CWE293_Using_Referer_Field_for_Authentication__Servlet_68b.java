/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE293_Using_Referer_Field_for_Authentication__Servlet_68b.java
Label Definition File: CWE293_Using_Referer_Field_for_Authentication__Servlet.label.xml
Template File: source-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 293 Using Referer Field For Authentication
 * BadSource: hardcodedPasswordServlet Data from referer
 * Sinks: refererServlet
 *    GoodSink: use referer to print data
 *    BadSink : use referer in auth decision
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE293_Using_Referer_Field_for_Authentication;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;

public class CWE293_Using_Referer_Field_for_Authentication__Servlet_68b
{

    public void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE293_Using_Referer_Field_for_Authentication__Servlet_68a.data;

        /* POTENTIAL FLAW: Using Referer header for authentication */
        if(data.equals("http://real.authentication.com/login_success.jsp"))
        {
            /* you're authenticated! */
            response.getWriter().write("You are authenticated!");
            request.getSession(true).setAttribute("authenticated", true);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE293_Using_Referer_Field_for_Authentication__Servlet_68a.data;

        /* FIX: Use Referer in some other way */
        if (data.equals("http://www.google.com"))
        {
            response.getWriter().write("Welcome Google Searcher!");
        }

    }
}
