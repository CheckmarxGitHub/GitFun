/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_Environment_17.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-17.tmpl.java
*/
/*
* @description
* CWE: 80 Cross Site Scripting (XSS)
* BadSource: Environment Read a string from an environment variable
* GoodSource: A hardcoded string
* BadSink: Servlet querystring parameter not sanitized
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE80_XSS;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE80_XSS__Servlet_Environment_17 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }

        if (data != null)
        {
            /* POTENTIAL FLAW: data not validated */
            response.getWriter().println("<br>bad() - Parameter name has value " + data);
        }

    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statement with the one in the for statement */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }

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
