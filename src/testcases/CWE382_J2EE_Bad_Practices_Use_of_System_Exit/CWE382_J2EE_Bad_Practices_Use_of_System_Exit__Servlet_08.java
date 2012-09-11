/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_J2EE_Bad_Practices_Use_of_System_Exit__Servlet_08.java
Label Definition File: CWE382_J2EE_Bad_Practices_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 382 bad case calls System.exit during a normal work flow.
 Note: System.exit may be justifiable if
  a) significant failures occur during application initialization.
  b) the program is invoked by another application and intended to exit with a
  status code to determine success/failure.
 Otherwise alternatives, such as throwing exceptions should be used as a fail safe
 measure.
* Sinks:
*    GoodSink: notify user, do not use System.exit
*    BadSink : calling System.exit, breaching best practices
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE382_J2EE_Bad_Practices_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.IOException;

public class CWE382_J2EE_Bad_Practices_Use_of_System_Exit__Servlet_08 extends AbstractTestCaseServlet
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
            System.exit(1); /* FLAW: use of System.exit */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            System.exit(1); /* FLAW: use of System.exit */
        }
        else {

            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_t())
        {
            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            System.exit(1); /* FLAW: use of System.exit */

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
