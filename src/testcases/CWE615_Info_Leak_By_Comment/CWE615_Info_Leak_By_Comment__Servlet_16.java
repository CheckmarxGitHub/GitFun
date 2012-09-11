/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE615_Info_Leak_By_Comment__Servlet_16.java
Label Definition File: CWE615_Info_Leak_By_Comment__Servlet.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 615 Information Leak by Comment
* Sinks:
*    GoodSink: no disclosure of username and password
*    BadSink : disclose username and password
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE615_Info_Leak_By_Comment;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE615_Info_Leak_By_Comment__Servlet_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            /* FLAW: sensitive information leaked in client-side code comments */
            response.getWriter().println("<!--DB username = joe, DB password = 123-->" +
            "<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: no info leak in client-side code comments */
            response.getWriter().println("<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: sensitive information leaked in client-side code comments */
            response.getWriter().println("<!--DB username = joe, DB password = 123-->" +
            "<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");
            break;
        }

        while(true)
        {
            /* FIX: no info leak in client-side code comments */
            response.getWriter().println("<form action=\"/test\" method=post>" +
            "<input type=text name=dbusername>" +
            "<input type=test name=dbpassword>" +
            "<input type=submit value=Submit>" +
            "</form>");
            break;
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
