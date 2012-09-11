/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE535_Info_Leak_Shell_Error__Servlet_05.java
Label Definition File: CWE535_Info_Leak_Shell_Error__Servlet.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 535 Information Leak through Shell Error
* Sinks:
*    GoodSink: write non-sensitive information to stderr
*    BadSink : leak the session ID to stderr
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE535_Info_Leak_Shell_Error;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE535_Info_Leak_Shell_Error__Servlet_05 extends AbstractTestCaseServlet
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
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                PrintWriter out = new PrintWriter(System.err);
                /* FLAW: leak session ID to stderr */
                out.println("Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (request.getParameter("username") == null)
            {
                return;
            }

            String username = request.getParameter("username");
            PrintWriter out = new PrintWriter(System.err);

            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FIX: message to stderr does not contain session id */
                out.println("Username: " + username + " logged in");
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }

        }
    }

    /* good1() changes private_t to private_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                PrintWriter out = new PrintWriter(System.err);
                /* FLAW: leak session ID to stderr */
                out.println("Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
        }
        else {

            if (request.getParameter("username") == null)
            {
                return;
            }

            String username = request.getParameter("username");
            PrintWriter out = new PrintWriter(System.err);

            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FIX: message to stderr does not contain session id */
                out.println("Username: " + username + " logged in");
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_t)
        {
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            PrintWriter out = new PrintWriter(System.err);
            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FIX: message to stderr does not contain session id */
                out.println("Username: " + username + " logged in");
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (request.getParameter("username") == null)
            {
                return;
            }

            String username = request.getParameter("username");

            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                PrintWriter out = new PrintWriter(System.err);
                /* FLAW: leak session ID to stderr */
                out.println("Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
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
