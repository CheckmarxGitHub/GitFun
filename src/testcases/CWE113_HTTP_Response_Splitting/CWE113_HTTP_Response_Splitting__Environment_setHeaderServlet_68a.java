/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_68a.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-68a.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: setHeaderServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to setHeader()
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_68a extends AbstractTestCaseServlet
{

    public static String data;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        (new CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_68b()).bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_68b()).goodG2B_sink(request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        (new CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_68b()).goodB2G_sink(request, response);
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
