/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE293_Using_Referer_Field_for_Authentication__Servlet_53c.java
Label Definition File: CWE293_Using_Referer_Field_for_Authentication__Servlet.label.xml
Template File: source-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 293 Using Referer Field For Authentication
 * BadSource: hardcodedPasswordServlet Data from referer
 * Sinks: refererServlet
 *    GoodSink: use referer to print data
 *    BadSink : use referer in auth decision
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE293_Using_Referer_Field_for_Authentication;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE293_Using_Referer_Field_for_Authentication__Servlet_53c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE293_Using_Referer_Field_for_Authentication__Servlet_53d()).bad_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE293_Using_Referer_Field_for_Authentication__Servlet_53d()).goodB2G_sink(data , request, response);
    }
}
