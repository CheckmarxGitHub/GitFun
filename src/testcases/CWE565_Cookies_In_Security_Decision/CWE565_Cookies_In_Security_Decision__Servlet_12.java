/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE565_Cookies_In_Security_Decision__Servlet_12.java
Label Definition File: CWE565_Cookies_In_Security_Decision__Servlet.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 565 Cookies used to make a security decision; in this case a cookie is used to tell whether someone has administrator privileges
* Sinks: cookieInSecurityDecisionServlet
*    GoodSink: Uses isUserInRole() to authorize user
*    BadSink : Uses the cookie to authorize user
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE565_Cookies_In_Security_Decision;

import testcasesupport.*;

import javax.servlet.http.*;
import java.security.Permissions;
import java.security.SecurityPermission;
import java.io.IOException;

public class CWE565_Cookies_In_Security_Decision__Servlet_12 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.static_returns_t_or_f())
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

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(IO.static_returns_t_or_f())
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
