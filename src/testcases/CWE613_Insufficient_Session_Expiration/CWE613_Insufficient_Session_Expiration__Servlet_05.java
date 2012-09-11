/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE613_Insufficient_Session_Expiration__Servlet_05.java
Label Definition File: CWE613_Insufficient_Session_Expiration__Servlet.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 613 Insufficient Session Expiration
* Sinks:
*    GoodSink: force session to expire
*    BadSink : set session to never expire
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE613_Insufficient_Session_Expiration;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE613_Insufficient_Session_Expiration__Servlet_05 extends AbstractTestCaseServlet
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_t)
        {
            HttpSession s = request.getSession(true);
            s.setMaxInactiveInterval(-1); /* FLAW: session does not expire */
            response.getWriter().write("bad(): Session still valid");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            HttpSession s = request.getSession(true);

            /* FIX: enforce an absolute session timeout of 30 seconds */
            if (s.getCreationTime() + 30000 > System.currentTimeMillis())
            {
                response.getWriter().write("good(): Invalidating session per absolute timeout enforcement");
                s.invalidate();
                return;
            }
            else
            {
                response.getWriter().write("good(): Session still valid");
            }

        }
    }

    /* good1() changes private_t to private_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            HttpSession s = request.getSession(true);
            s.setMaxInactiveInterval(-1); /* FLAW: session does not expire */
            response.getWriter().write("bad(): Session still valid");
        }
        else {

            HttpSession s = request.getSession(true);

            /* FIX: enforce an absolute session timeout of 30 seconds */
            if (s.getCreationTime() + 30000 > System.currentTimeMillis())
            {
                response.getWriter().write("good(): Invalidating session per absolute timeout enforcement");
                s.invalidate();
                return;
            }
            else
            {
                response.getWriter().write("good(): Session still valid");
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_t)
        {
            HttpSession s = request.getSession(true);
            /* FIX: enforce an absolute session timeout of 30 seconds */
            if (s.getCreationTime() + 30000 > System.currentTimeMillis())
            {
                response.getWriter().write("good(): Invalidating session per absolute timeout enforcement");
                s.invalidate();
                return;
            }
            else
            {
                response.getWriter().write("good(): Session still valid");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            HttpSession s = request.getSession(true);
            s.setMaxInactiveInterval(-1); /* FLAW: session does not expire */

            response.getWriter().write("bad(): Session still valid");

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
