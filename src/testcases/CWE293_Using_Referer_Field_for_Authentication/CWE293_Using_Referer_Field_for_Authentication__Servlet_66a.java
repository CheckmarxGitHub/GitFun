/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE293_Using_Referer_Field_for_Authentication__Servlet_66a.java
Label Definition File: CWE293_Using_Referer_Field_for_Authentication__Servlet.label.xml
Template File: source-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 293 Using Referer Field For Authentication
 * BadSource: hardcodedPasswordServlet Data from referer
 * Sinks: refererServlet
 *    GoodSink: use referer to print data
 *    BadSink : use referer in auth decision
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE293_Using_Referer_Field_for_Authentication;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE293_Using_Referer_Field_for_Authentication__Servlet_66a extends AbstractTestCaseServlet
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

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE293_Using_Referer_Field_for_Authentication__Servlet_66b()).bad_sink(data_array , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodB2G(request, response);
    }

    /* goodB2G() - use badsource and goodsink */
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

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE293_Using_Referer_Field_for_Authentication__Servlet_66b()).goodB2G_sink(data_array , request, response );
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
