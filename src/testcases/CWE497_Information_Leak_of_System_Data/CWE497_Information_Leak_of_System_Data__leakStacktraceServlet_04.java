/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE497_Information_Leak_of_System_Data__leakStacktraceServlet_04.java
Label Definition File: CWE497_Information_Leak_of_System_Data.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 497 Information Leak
* Sinks: leakStacktraceServlet
*    GoodSink: no leaking
*    BadSink : leak the path variable to the user
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE497_Information_Leak_of_System_Data;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE497_Information_Leak_of_System_Data__leakStacktraceServlet_04 extends AbstractTestCaseServlet
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_final_t)
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

    /* good1() changes private_final_t to private_final_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_final_f)
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
        if(private_final_t)
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
