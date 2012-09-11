/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE489_Leftover_Debug_Code__Servlet_08.java
Label Definition File: CWE489_Leftover_Debug_Code__Servlet.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 489 Leftover Debug Code
* Sinks:
*    GoodSink: no debugging bypass
*    BadSink : debugging request parameter bypasses authentication
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE489_Leftover_Debug_Code;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE489_Leftover_Debug_Code__Servlet_08 extends AbstractTestCaseServlet
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
            if (request.getParameter("username") == null ||
            request.getParameter("password") == null)
            {
                return;
            }
            Boolean isAuthenticated = false;
            HttpSession session = request.getSession(true);
            /* FLAW: debug flag bypasses authentication mechanism */
            if (request.getParameter("debug") != null &&
            request.getParameter("debug").equals("1"))
            {
                session.setAttribute("username", "admin");
                session.setAttribute("isAdmin", "true");
                isAuthenticated = true;
            }
            else
            {
                /* INCIDENTAL: hardcoded username and password */
                if (request.getParameter("username").equals("testuser") &&
                request.getParameter("password").equals("012345679ABCDEF"))
                {
                    session.setAttribute("username", "testuser");
                    session.setAttribute("isAdmin", "false");
                    isAuthenticated = true;
                }
                else
                {
                    isAuthenticated = false;
                }
            }
            if (isAuthenticated)
            {
                response.getWriter().println("You are authenticated!");
            }
            else
            {
                response.getWriter().println("Sorry, bad username or password.");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (request.getParameter("username") == null ||
            request.getParameter("password") == null)
            {
                return;
            }

            Boolean isAuthenticated = false;
            HttpSession session = request.getSession(true);
            /* FIX: debug code removed */
            /* INCIDENTAL: hardcoded username and password */
            if (request.getParameter("username").equals("testuser") &&
            request.getParameter("password").equals("012345679ABCDEF"))
            {
                session.setAttribute("username", "testuser");
                session.setAttribute("isAdmin", "false");
                isAuthenticated = true;
            }
            else
            {
                isAuthenticated = false;
            }

            if (isAuthenticated)
            {
                response.getWriter().println("You are authenticated!");
            }
            else
            {
                response.getWriter().println("Sorry, bad username or password.");
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            if (request.getParameter("username") == null ||
            request.getParameter("password") == null)
            {
                return;
            }
            Boolean isAuthenticated = false;
            HttpSession session = request.getSession(true);
            /* FLAW: debug flag bypasses authentication mechanism */
            if (request.getParameter("debug") != null &&
            request.getParameter("debug").equals("1"))
            {
                session.setAttribute("username", "admin");
                session.setAttribute("isAdmin", "true");
                isAuthenticated = true;
            }
            else
            {
                /* INCIDENTAL: hardcoded username and password */
                if (request.getParameter("username").equals("testuser") &&
                request.getParameter("password").equals("012345679ABCDEF"))
                {
                    session.setAttribute("username", "testuser");
                    session.setAttribute("isAdmin", "false");
                    isAuthenticated = true;
                }
                else
                {
                    isAuthenticated = false;
                }
            }
            if (isAuthenticated)
            {
                response.getWriter().println("You are authenticated!");
            }
            else
            {
                response.getWriter().println("Sorry, bad username or password.");
            }
        }
        else {

            if (request.getParameter("username") == null ||
            request.getParameter("password") == null)
            {
                return;
            }

            Boolean isAuthenticated = false;
            HttpSession session = request.getSession(true);
            /* FIX: debug code removed */
            /* INCIDENTAL: hardcoded username and password */
            if (request.getParameter("username").equals("testuser") &&
            request.getParameter("password").equals("012345679ABCDEF"))
            {
                session.setAttribute("username", "testuser");
                session.setAttribute("isAdmin", "false");
                isAuthenticated = true;
            }
            else
            {
                isAuthenticated = false;
            }

            if (isAuthenticated)
            {
                response.getWriter().println("You are authenticated!");
            }
            else
            {
                response.getWriter().println("Sorry, bad username or password.");
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_t())
        {
            if (request.getParameter("username") == null ||
            request.getParameter("password") == null)
            {
                return;
            }
            Boolean isAuthenticated = false;
            HttpSession session = request.getSession(true);
            /* FIX: debug code removed */
            /* INCIDENTAL: hardcoded username and password */
            if (request.getParameter("username").equals("testuser") &&
            request.getParameter("password").equals("012345679ABCDEF"))
            {
                session.setAttribute("username", "testuser");
                session.setAttribute("isAdmin", "false");
                isAuthenticated = true;
            }
            else
            {
                isAuthenticated = false;
            }
            if (isAuthenticated)
            {
                response.getWriter().println("You are authenticated!");
            }
            else
            {
                response.getWriter().println("Sorry, bad username or password.");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (request.getParameter("username") == null ||
            request.getParameter("password") == null)
            {
                return;
            }

            Boolean isAuthenticated = false;
            HttpSession session = request.getSession(true);
            /* FLAW: debug flag bypasses authentication mechanism */
            if (request.getParameter("debug") != null &&
            request.getParameter("debug").equals("1"))
            {
                session.setAttribute("username", "admin");
                session.setAttribute("isAdmin", "true");
                isAuthenticated = true;
            }
            else
            {
                /* INCIDENTAL: hardcoded username and password */
                if (request.getParameter("username").equals("testuser") &&
                request.getParameter("password").equals("012345679ABCDEF"))
                {
                    session.setAttribute("username", "testuser");
                    session.setAttribute("isAdmin", "false");
                    isAuthenticated = true;
                }
                else
                {
                    isAuthenticated = false;
                }
            }

            if (isAuthenticated)
            {
                response.getWriter().println("You are authenticated!");
            }
            else
            {
                response.getWriter().println("Sorry, bad username or password.");
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
