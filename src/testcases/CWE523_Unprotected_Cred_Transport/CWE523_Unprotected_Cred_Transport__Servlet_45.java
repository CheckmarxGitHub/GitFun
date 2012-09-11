/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE523_Unprotected_Cred_Transport__Servlet_45.java
Label Definition File: CWE523_Unprotected_Cred_Transport__Servlet.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 523 Unprotected Transportation of Credentials
 * BadSource: credentials Send login credentials
 * GoodSource: Send non-sensitive information
 * Sinks: non_ssl
 *    GoodSink: Send across SSL connection
 *    BadSink : Send across potentially non-SSL connection
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE523_Unprotected_Cred_Transport;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE523_Unprotected_Cred_Transport__Servlet_45 extends AbstractTestCaseServlet
{

    private String bad_data;
    private String goodG2B_data;
    private String goodB2G_data;

    private void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = bad_data;

        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            /* POTENTIAL FLAW: transmitting login credentials across a possibly non-SSL connection */
            out.println(data);
        }
        catch( IOException e )
        {
            IO.writeLine("There was a problem writing");
        }
        finally
        {
            if( out != null )
            {
                out.close();
            }
        }

    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: sending login credentials information */
        data = "Your username is: user1\nYour password is: w8KNdsa9\n";

        bad_data = data;
        bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodG2B_data;

        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            /* POTENTIAL FLAW: transmitting login credentials across a possibly non-SSL connection */
            out.println(data);
        }
        catch( IOException e )
        {
            IO.writeLine("There was a problem writing");
        }
        finally
        {
            if( out != null )
            {
                out.close();
            }
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /*FIX: send non-sensitive information */
        data = "The weather is San Diego is 75 and sunny";

        goodG2B_data = data;
        goodG2B_sink(request, response);
    }

    private void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodB2G_data;

        PrintWriter out = null;
        try
        {
            /* FIX: ensure the connection is secure */
            if( request.isSecure() )
            {
                out = response.getWriter();
                out.println(data);
            }
        }
        catch( IOException e )
        {
            IO.writeLine("There was a problem writing");
        }
        finally
        {
            if( out != null )
            {
                out.close();
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: sending login credentials information */
        data = "Your username is: user1\nYour password is: w8KNdsa9\n";

        goodB2G_data = data;
        goodB2G_sink(request, response);
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
