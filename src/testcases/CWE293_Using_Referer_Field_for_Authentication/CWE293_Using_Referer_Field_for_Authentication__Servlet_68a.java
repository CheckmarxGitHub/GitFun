/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE293_Using_Referer_Field_for_Authentication__Servlet_68a.java
Label Definition File: CWE293_Using_Referer_Field_for_Authentication__Servlet.label.xml
Template File: source-sinks-68a.tmpl.java
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

public class CWE293_Using_Referer_Field_for_Authentication__Servlet_68a extends AbstractTestCaseServlet
{

    public static String data;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (request.getHeader("Referer") == null)
        {
            response.getWriter().write("Referer not set");
            data = "";
        }
        else {
            data = request.getHeader("Referer");
        }

        (new CWE293_Using_Referer_Field_for_Authentication__Servlet_68b()).bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodB2G(request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (request.getHeader("Referer") == null)
        {
            response.getWriter().write("Referer not set");
            data = "";
        }
        else {
            data = request.getHeader("Referer");
        }

        (new CWE293_Using_Referer_Field_for_Authentication__Servlet_68b()).goodB2G_sink(request, response);
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
