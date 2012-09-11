/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE497_Information_Leak_of_System_Data__leakPathServlet_06.java
Label Definition File: CWE497_Information_Leak_of_System_Data.label.xml
Template File: point-flaw-06.tmpl.java
*/
/*
* @description
* CWE: 497 Information Leak
* Sinks: leakPathServlet
*    GoodSink: no leaking
*    BadSink : leak the path variable to the user
* Flow Variant: 06 Control flow: if(private_final_five==5) and if(private_final_five!=5)
*
* */

package testcases.CWE497_Information_Leak_of_System_Data;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE497_Information_Leak_of_System_Data__leakPathServlet_06 extends AbstractTestCaseServlet
{

    /* The variable below is declared "final", so a tool should be able
       to identify that reads of this will always give its initialized
       value. */
    private final int private_final_five = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_final_five==5)
        {
            /* FLAW: system information exposed */
            response.getWriter().println("Not in path: " + System.getenv("PATH"));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: error message is general */
            response.getWriter().println("Not in path");

        }
    }

    /* good1() changes private_final_five==5 to private_final_five!=5 */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: system information exposed */
            response.getWriter().println("Not in path: " + System.getenv("PATH"));
        }
        else {

            /* FIX: error message is general */
            response.getWriter().println("Not in path");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_final_five==5)
        {
            /* FIX: error message is general */
            response.getWriter().println("Not in path");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: system information exposed */
            response.getWriter().println("Not in path: " + System.getenv("PATH"));

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
