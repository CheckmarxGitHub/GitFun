/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE497_Information_Leak_of_System_Data__leakStacktraceServlet_08.java
Label Definition File: CWE497_Information_Leak_of_System_Data.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 497 Information Leak
* Sinks: leakStacktraceServlet
*    GoodSink: no leaking
*    BadSink : leak the path variable to the user
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE497_Information_Leak_of_System_Data;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE497_Information_Leak_of_System_Data__leakStacktraceServlet_08 extends AbstractTestCaseServlet
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_returns_t())
        {
            try
            {
                throw new Exception("Testing!");
            }
            catch(Exception e)
            {
                /* Note: this will likely result in an incidental issue for using .printStackTrace() */
                e.printStackTrace(response.getWriter()); /* FLAW: stack trace details */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                throw new Exception("Testing!");
            }
            catch(Exception e)
            {
                IO.writeLine("An error occurred!"); /* FIX: sensitive system details omitted in output */
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                throw new Exception("Testing!");
            }
            catch(Exception e)
            {
                /* Note: this will likely result in an incidental issue for using .printStackTrace() */
                e.printStackTrace(response.getWriter()); /* FLAW: stack trace details */
            }
        }
        else {

            try
            {
                throw new Exception("Testing!");
            }
            catch(Exception e)
            {
                IO.writeLine("An error occurred!"); /* FIX: sensitive system details omitted in output */
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_t())
        {
            try
            {
                throw new Exception("Testing!");
            }
            catch(Exception e)
            {
                IO.writeLine("An error occurred!"); /* FIX: sensitive system details omitted in output */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                throw new Exception("Testing!");
            }
            catch(Exception e)
            {
                /* Note: this will likely result in an incidental issue for using .printStackTrace() */
                e.printStackTrace(response.getWriter()); /* FLAW: stack trace details */
            }

        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
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
