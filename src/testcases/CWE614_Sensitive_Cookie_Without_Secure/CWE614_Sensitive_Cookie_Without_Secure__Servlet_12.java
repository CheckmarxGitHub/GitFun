/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE614_Sensitive_Cookie_Without_Secure__Servlet_12.java
Label Definition File: CWE614_Sensitive_Cookie_Without_Secure__Servlet.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 614 Sensitive Cookie Without Secure
* Sinks:
*    GoodSink: secure flag set
*    BadSink : secure flag not set
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE614_Sensitive_Cookie_Without_Secure;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE614_Sensitive_Cookie_Without_Secure__Servlet_12 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            Cookie c = new Cookie("SecretMessage", "test");
            if( request.isSecure() )
            {
                response.addCookie(c); /* FLAW: secure flag not set */
            }
        }
        else {

            Cookie c = new Cookie("SecretMessage", "Drink your Ovaltine");
            if( request.isSecure() )
            {
                c.setSecure(true); /* FIX: adds "secure" flag/attribute to cookie */
                response.addCookie(c);
            }

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            Cookie c = new Cookie("SecretMessage", "Drink your Ovaltine");
            if( request.isSecure() )
            {
                c.setSecure(true); /* FIX: adds "secure" flag/attribute to cookie */
                response.addCookie(c);
            }
        }
        else {

            Cookie c = new Cookie("SecretMessage", "Drink your Ovaltine");
            if( request.isSecure() )
            {
                c.setSecure(true); /* FIX: adds "secure" flag/attribute to cookie */
                response.addCookie(c);
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
