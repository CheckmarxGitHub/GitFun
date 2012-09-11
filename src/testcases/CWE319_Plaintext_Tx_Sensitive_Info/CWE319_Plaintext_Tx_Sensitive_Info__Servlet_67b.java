/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67b.java
Label Definition File: CWE319_Plaintext_Tx_Sensitive_Info__Servlet.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Plaintext Transmission of Sensitive Information
 * BadSource: account_balance Send sensitive information
 * GoodSource: Send non-sensitive information
 * Sinks: non_ssl
 *    GoodSink: Send across SSL connection
 *    BadSink : Send across potentially non-SSL connection
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE319_Plaintext_Tx_Sensitive_Info;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67b
{

    public void bad_sink(CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            /* POTENTIAL FLAW: transmitting sensitive info across a possibly non-SSL connection */
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
    public void goodG2B_sink(CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            /* POTENTIAL FLAW: transmitting sensitive info across a possibly non-SSL connection */
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
    public void goodB2G_sink(CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

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
