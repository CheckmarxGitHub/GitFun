/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE523_Unprotected_Cred_Transport__Servlet_52c.java
Label Definition File: CWE523_Unprotected_Cred_Transport__Servlet.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 523 Unprotected Transportation of Credentials
 * BadSource: credentials Send login credentials
 * GoodSource: Send non-sensitive information
 * Sinks: non_ssl
 *    GoodSink: Send across SSL connection
 *    BadSink : Send across potentially non-SSL connection
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE523_Unprotected_Cred_Transport;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE523_Unprotected_Cred_Transport__Servlet_52c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

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
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

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

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

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
}
