/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Access_Through_SQL_Primary__Servlet_67a.java
Label Definition File: CWE566_Access_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 566 Access through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * Sinks: writeConsole
 *    GoodSink: user permissions checked
 *    BadSink : user authorization not checked
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE566_Access_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE566_Access_Through_SQL_Primary__Servlet_67a extends AbstractTestCaseServlet
{

    static class Container
    {
        public String a;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = request.getParameter("id");

        Container data_container = new Container();
        data_container.a = data;
        (new CWE566_Access_Through_SQL_Primary__Servlet_67b()).bad_sink(data_container , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = "10";

        Container data_container = new Container();
        data_container.a = data;
        (new CWE566_Access_Through_SQL_Primary__Servlet_67b()).goodG2B_sink(data_container , request, response );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = request.getParameter("id");

        Container data_container = new Container();
        data_container.a = data;
        (new CWE566_Access_Through_SQL_Primary__Servlet_67b()).goodB2G_sink(data_container , request, response );
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
