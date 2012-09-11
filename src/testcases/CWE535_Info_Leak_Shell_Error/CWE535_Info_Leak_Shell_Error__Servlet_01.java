/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE535_Info_Leak_Shell_Error__Servlet_01.java
Label Definition File: CWE535_Info_Leak_Shell_Error__Servlet.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 535 Information Leak through Shell Error
* Sinks:
*    GoodSink: write non-sensitive information to stderr
*    BadSink : leak the session ID to stderr
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE535_Info_Leak_Shell_Error;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE535_Info_Leak_Shell_Error__Servlet_01 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

