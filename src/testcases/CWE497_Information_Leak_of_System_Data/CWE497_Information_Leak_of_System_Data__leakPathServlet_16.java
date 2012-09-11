/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE497_Information_Leak_of_System_Data__leakPathServlet_16.java
Label Definition File: CWE497_Information_Leak_of_System_Data.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 497 Information Leak
* Sinks: leakPathServlet
*    GoodSink: no leaking
*    BadSink : leak the path variable to the user
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE497_Information_Leak_of_System_Data;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE497_Information_Leak_of_System_Data__leakPathServlet_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            /* FLAW: system information exposed */
            response.getWriter().println("Not in path: " + System.getenv("PATH"));
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: error message is general */
            response.getWriter().println("Not in path");
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: system information exposed */
            response.getWriter().println("Not in path: " + System.getenv("PATH"));
            break;
        }

        while(true)
        {
            /* FIX: error message is general */
            response.getWriter().println("Not in path");
            break;
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
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
