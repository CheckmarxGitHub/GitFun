/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Plaintext_Tx_Sensitive_Info__Servlet_12.java
Label Definition File: CWE319_Plaintext_Tx_Sensitive_Info__Servlet.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 319 Plaintext Transmission of Sensitive Information
* BadSource: account_balance Send sensitive information
* GoodSource: Send non-sensitive information
* Sinks: non_ssl
*    GoodSink: Send across SSL connection
*    BadSink : Send across potentially non-SSL connection
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE319_Plaintext_Tx_Sensitive_Info;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE319_Plaintext_Tx_Sensitive_Info__Servlet_12 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: sending sensitive information */
            data = "This is your bank account info: Account Number: 12345, Balance: $1,000,000";
        }
        else {

            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";

        }
        if(IO.static_returns_t_or_f())
        {
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
        else {

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

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";
        }
        else {

            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";

        }
        if(IO.static_returns_t_or_f())
        {
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
        else {

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
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: sending sensitive information */
            data = "This is your bank account info: Account Number: 12345, Balance: $1,000,000";
        }
        else {

            /* POTENTIAL FLAW: sending sensitive information */
            data = "This is your bank account info: Account Number: 12345, Balance: $1,000,000";

        }
        if(IO.static_returns_t_or_f())
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
        else {

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

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
