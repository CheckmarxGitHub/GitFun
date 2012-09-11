/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE523_Unprotected_Cred_Transport__Servlet_06.java
Label Definition File: CWE523_Unprotected_Cred_Transport__Servlet.label.xml
Template File: sources-sinks-06.tmpl.java
*/
/*
* @description
* CWE: 523 Unprotected Transportation of Credentials
* BadSource: credentials Send login credentials
* GoodSource: Send non-sensitive information
* Sinks: non_ssl
*    GoodSink: Send across SSL connection
*    BadSink : Send across potentially non-SSL connection
* Flow Variant: 06 Control flow: if(private_final_five==5) and if(private_final_five!=5)
*
* */

package testcases.CWE523_Unprotected_Cred_Transport;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE523_Unprotected_Cred_Transport__Servlet_06 extends AbstractTestCaseServlet
{

    /* The variable below is declared "final", so a tool should be able
       to identify that reads of this will always give its initialized
       value. */
    private final int private_final_five = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* POTENTIAL FLAW: sending login credentials information */
            data = "Your username is: user1\nYour password is: w8KNdsa9\n";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B1() - use goodsource and badsink by changing first private_final_five==5 to private_final_five!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: sending login credentials information */
            data = "Your username is: user1\nYour password is: w8KNdsa9\n";
        }
        else {

            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: sending login credentials information */
            data = "Your username is: user1\nYour password is: w8KNdsa9\n";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodB2G1() - use badsource and goodsink by changing second private_final_five==5 to private_final_five!=5 */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* POTENTIAL FLAW: sending login credentials information */
            data = "Your username is: user1\nYour password is: w8KNdsa9\n";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
        {
            /* POTENTIAL FLAW: sending login credentials information */
            data = "Your username is: user1\nYour password is: w8KNdsa9\n";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_five==5)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
