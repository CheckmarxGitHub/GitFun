/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE523_Unprotected_Cred_Transport__Servlet_16.java
Label Definition File: CWE523_Unprotected_Cred_Transport__Servlet.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 523 Unprotected Transportation of Credentials
* BadSource: credentials Send login credentials
* GoodSource: Send non-sensitive information
* Sinks: non_ssl
*    GoodSink: Send across SSL connection
*    BadSink : Send across potentially non-SSL connection
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE523_Unprotected_Cred_Transport;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE523_Unprotected_Cred_Transport__Servlet_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: sending login credentials information */
            data = "Your username is: user1\nYour password is: w8KNdsa9\n";
            break;
        }

        while(true)
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
            break;
        }

        while(local_f)
        {
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
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: sending login credentials information */
            data = "Your username is: user1\nYour password is: w8KNdsa9\n";
            break;
        }

        while(true)
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
            break;
        }

        while(local_f)
        {
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
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /*FIX: send non-sensitive information */
            data = "The weather is San Diego is 75 and sunny";
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: sending login credentials information */
            data = "Your username is: user1\nYour password is: w8KNdsa9\n";
            break;
        }

        while(local_f)
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
            break;
        }

        while(true)
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
            break;
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
