/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE534_Info_Leak_Debug_Log__Servlet_02.java
Label Definition File: CWE534_Info_Leak_Debug_Log__Servlet.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 534 Information Leak through Debug Log Files
* Sinks:
*    GoodSink: log non-sensitive information to the debug log
*    BadSink : leak the session ID to the debug log
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE534_Info_Leak_Debug_Log;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.logging.*;

public class CWE534_Info_Leak_Debug_Log__Servlet_02 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (true)
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

    /* good1() changes true to false */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(false)
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
        if(true)
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
