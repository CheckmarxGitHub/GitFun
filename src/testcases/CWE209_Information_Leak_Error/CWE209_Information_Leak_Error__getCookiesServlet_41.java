/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__getCookiesServlet_41.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 209 Information exposure through error message
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks: stackDump
 *    GoodSink: Generic error message
 *    BadSink : Error causes stack dump
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE209_Information_Leak_Error__getCookiesServlet_41 extends AbstractTestCaseServlet
{

    private void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        try
        {
            int iConversion = Integer.valueOf(data);
        }
        catch( Exception e )
        {
            e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
        }

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

        bad_sink(data , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        try
        {
            int iConversion = Integer.valueOf(data);
        }
        catch( Exception e )
        {
            e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2B_sink(data , request, response );
    }

    private void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        try
        {
            int iConversion = Integer.valueOf(data);
        }
        catch( Exception e )
        {
            IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
        }

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

        goodB2G_sink(data , request, response );
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
