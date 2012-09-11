/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE382_J2EE_Bad_Practices_Use_of_System_Exit__Servlet_16.java
Label Definition File: CWE382_J2EE_Bad_Practices_Use_of_System_Exit__Servlet.label.xml
Template File: point-flaw-16.tmpl.java
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
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE382_J2EE_Bad_Practices_Use_of_System_Exit;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.IOException;

public class CWE382_J2EE_Bad_Practices_Use_of_System_Exit__Servlet_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            System.exit(1); /* FLAW: use of System.exit */
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */
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
            System.exit(1); /* FLAW: use of System.exit */
            break;
        }

        while(true)
        {
            response.getWriter().write("You cannot shut down this application, only the admin can"); /* FIX: fail safe */
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
