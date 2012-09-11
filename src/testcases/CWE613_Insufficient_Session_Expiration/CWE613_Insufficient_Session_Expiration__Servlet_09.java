/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE613_Insufficient_Session_Expiration__Servlet_09.java
Label Definition File: CWE613_Insufficient_Session_Expiration__Servlet.label.xml
Template File: point-flaw-09.tmpl.java
*/
/*
* @description
* CWE: 613 Insufficient Session Expiration
* Sinks:
*    GoodSink: force session to expire
*    BadSink : set session to never expire
* Flow Variant: 09 Control flow: if(IO.static_final_t) and if(IO.static_final_f)
*
* */

package testcases.CWE613_Insufficient_Session_Expiration;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE613_Insufficient_Session_Expiration__Servlet_09 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.static_final_t)
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

    /* good1() changes IO.static_final_t to IO.static_final_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(IO.static_final_f)
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
        if(IO.static_final_t)
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
