/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE293_Using_Referer_Field_for_Authentication__Servlet_61b.java
Label Definition File: CWE293_Using_Referer_Field_for_Authentication__Servlet.label.xml
Template File: source-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 293 Using Referer Field For Authentication
 * BadSource: hardcodedPasswordServlet Data from referer
 * Sinks: refererServlet
 *    GoodSink: use referer to print data
 *    BadSink : use referer in auth decision
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE293_Using_Referer_Field_for_Authentication;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE293_Using_Referer_Field_for_Authentication__Servlet_61b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public String goodB2G_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        return data;
    }
}
