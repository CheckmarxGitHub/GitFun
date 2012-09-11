/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getCookiesServlet_executeQuery_67a.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks: executeQuery
 *    GoodSink: prepared sqlstatement, executeQuery
 *    BadSink : raw query used in executeQuery
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__getCookiesServlet_executeQuery_67a extends AbstractTestCaseServlet
{

    static class Container
    {
        public String a;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            data = cookieSources[0].getValue();
        }
        else
        {
            data = null;
        }

        Container data_container = new Container();
        data_container.a = data;
        (new CWE89_SQL_Injection__getCookiesServlet_executeQuery_67b()).bad_sink(data_container , request, response );
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

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        Container data_container = new Container();
        data_container.a = data;
        (new CWE89_SQL_Injection__getCookiesServlet_executeQuery_67b()).goodG2B_sink(data_container , request, response );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            data = cookieSources[0].getValue();
        }
        else
        {
            data = null;
        }

        Container data_container = new Container();
        data_container.a = data;
        (new CWE89_SQL_Injection__getCookiesServlet_executeQuery_67b()).goodB2G_sink(data_container , request, response );
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
