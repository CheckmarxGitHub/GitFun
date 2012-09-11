/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE534_Info_Leak_Debug_Log__Servlet_04.java
Label Definition File: CWE534_Info_Leak_Debug_Log__Servlet.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 534 Information Leak through Debug Log Files
* Sinks:
*    GoodSink: log non-sensitive information to the debug log
*    BadSink : leak the session ID to the debug log
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE534_Info_Leak_Debug_Log;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.logging.*;

public class CWE534_Info_Leak_Debug_Log__Servlet_04 extends AbstractTestCaseServlet
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
            Logger tcLog = Logger.getLogger("cwe_testcases_logger");
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FLAW: leak session ID to debug log */
                tcLog.log(Level.FINEST, "Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger tcLog = Logger.getLogger("cwe_testcases_logger");
            if (request.getParameter("username") == null)
            {
                return;
            }

            String username = request.getParameter("username");

            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FIX: logged message does not contain session id */
                tcLog.log(Level.FINEST, "Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }

        }
    }

    /* good1() changes private_final_t to private_final_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger tcLog = Logger.getLogger("cwe_testcases_logger");
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FLAW: leak session ID to debug log */
                tcLog.log(Level.FINEST, "Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
        }
        else {

            Logger tcLog = Logger.getLogger("cwe_testcases_logger");
            if (request.getParameter("username") == null)
            {
                return;
            }

            String username = request.getParameter("username");

            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FIX: logged message does not contain session id */
                tcLog.log(Level.FINEST, "Username: " + username + " Session ID:" + session.getId());
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
        if(private_final_t)
        {
            Logger tcLog = Logger.getLogger("cwe_testcases_logger");
            if (request.getParameter("username") == null)
            {
                return;
            }
            String username = request.getParameter("username");
            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FIX: logged message does not contain session id */
                tcLog.log(Level.FINEST, "Username: " + username + " Session ID:" + session.getId());
            }
            else
            {
                response.getWriter().println("Invalid characters");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger tcLog = Logger.getLogger("cwe_testcases_logger");
            if (request.getParameter("username") == null)
            {
                return;
            }

            String username = request.getParameter("username");

            if (username.matches("[a-zA-Z0-9]*"))
            {
                HttpSession session = request.getSession(true);
                /* FLAW: leak session ID to debug log */
                tcLog.log(Level.FINEST, "Username: " + username + " Session ID:" + session.getId());
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
