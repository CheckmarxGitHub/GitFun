/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE565_Cookies_In_Security_Decision__Servlet_15.java
Label Definition File: CWE565_Cookies_In_Security_Decision__Servlet.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 565 Cookies used to make a security decision; in this case a cookie is used to tell whether someone has administrator privileges
* Sinks: cookieInSecurityDecisionServlet
*    GoodSink: Uses isUserInRole() to authorize user
*    BadSink : Uses the cookie to authorize user
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE565_Cookies_In_Security_Decision;

import testcasesupport.*;

import javax.servlet.http.*;
import java.security.Permissions;
import java.security.SecurityPermission;
import java.io.IOException;

public class CWE565_Cookies_In_Security_Decision__Servlet_15 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            HttpSession session = request.getSession(true);
            boolean admin = false;
            Cookie[] cookies = request.getCookies();
            for (int i=0; i<cookies.length; i++)
            {
                Cookie c = cookies[i];
                if (c.getName().equals("role"))
                {
                    if (c.getValue().equals("admin"))
                    {
                        admin = true;
                    }
                }
            }
            if (admin)
            {
                /* FLAW: Privilege is granted based on a cookie value */
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            HttpSession session = request.getSession(true);
            boolean admin = false;
            /* FIX:  do not use cookies to determin group membership*/
            admin = request.isUserInRole("admin");
            if (admin)
            {
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }
        }
        break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            HttpSession session = request.getSession(true);
            boolean admin = false;
            Cookie[] cookies = request.getCookies();
            for (int i=0; i<cookies.length; i++)
            {
                Cookie c = cookies[i];
                if (c.getName().equals("role"))
                {
                    if (c.getValue().equals("admin"))
                    {
                        admin = true;
                    }
                }
            }
            if (admin)
            {
                /* FLAW: Privilege is granted based on a cookie value */
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }
        }
        break;
        default:
        {
            HttpSession session = request.getSession(true);
            boolean admin = false;
            /* FIX:  do not use cookies to determin group membership*/
            admin = request.isUserInRole("admin");
            if (admin)
            {
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }
        }
        break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            HttpSession session = request.getSession(true);
            boolean admin = false;
            /* FIX:  do not use cookies to determin group membership*/
            admin = request.isUserInRole("admin");
            if (admin)
            {
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            HttpSession session = request.getSession(true);
            boolean admin = false;
            Cookie[] cookies = request.getCookies();
            for (int i=0; i<cookies.length; i++)
            {
                Cookie c = cookies[i];
                if (c.getName().equals("role"))
                {
                    if (c.getValue().equals("admin"))
                    {
                        admin = true;
                    }
                }
            }
            if (admin)
            {
                /* FLAW: Privilege is granted based on a cookie value */
                Permissions perms = new Permissions();
                perms.add(new SecurityPermission("admin"));
                session.setAttribute("permissions", perms);
            }
        }
        break;
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
