/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE565_Cookies_In_Security_Decision__Servlet_04.java
Label Definition File: CWE565_Cookies_In_Security_Decision__Servlet.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 565 Cookies used to make a security decision; in this case a cookie is used to tell whether someone has administrator privileges
* Sinks: cookieInSecurityDecisionServlet
*    GoodSink: Uses isUserInRole() to authorize user
*    BadSink : Uses the cookie to authorize user
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE565_Cookies_In_Security_Decision;

import testcasesupport.*;

import javax.servlet.http.*;
import java.security.Permissions;
import java.security.SecurityPermission;
import java.io.IOException;

public class CWE565_Cookies_In_Security_Decision__Servlet_04 extends AbstractTestCaseServlet
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
    }

    /* good1() changes private_final_t to private_final_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        else {

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
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_final_t)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
