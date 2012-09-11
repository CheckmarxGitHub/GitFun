/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_PropertiesFile_61a.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-61a.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: PropertiesFile Read a value from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: Servlet
 *    BadSink : querystring parameter not sanitized
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE80_XSS__Servlet_PropertiesFile_61a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE80_XSS__Servlet_PropertiesFile_61b()).bad_source(request, response);

        if (data != null)
        {
            /* POTENTIAL FLAW: data not validated */
            response.getWriter().println("<br>bad() - Parameter name has value " + data);
        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE80_XSS__Servlet_PropertiesFile_61b()).goodG2B_source(request, response);

        if (data != null)
        {
            /* POTENTIAL FLAW: data not validated */
            response.getWriter().println("<br>bad() - Parameter name has value " + data);
        }

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
