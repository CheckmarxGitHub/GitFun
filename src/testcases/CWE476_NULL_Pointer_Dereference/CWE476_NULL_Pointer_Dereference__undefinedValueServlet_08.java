/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__undefinedValueServlet_08.java
Label Definition File: CWE476_NULL_Pointer_Dereference.point.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* Sinks: undefinedValueServlet
*    GoodSink: checks for null before accessing the parameter
*    BadSink : assumes the parameter has been defined
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE476_NULL_Pointer_Dereference__undefinedValueServlet_08 extends AbstractTestCaseServlet
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
            String value = request.getParameter("asdf").trim(); /* FLAW: does not handle case where asdf was not specified in request */
            response.getWriter().println(value);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (request.getParameter("asdf") != null) /* FIX: verifies that parameter exists */
            {
                String value = request.getParameter("asdf").trim();
                response.getWriter().println(value);
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String value = request.getParameter("asdf").trim(); /* FLAW: does not handle case where asdf was not specified in request */
            response.getWriter().println(value);
        }
        else {

            if (request.getParameter("asdf") != null) /* FIX: verifies that parameter exists */
            {
                String value = request.getParameter("asdf").trim();
                response.getWriter().println(value);
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_t())
        {
            if (request.getParameter("asdf") != null) /* FIX: verifies that parameter exists */
            {
                String value = request.getParameter("asdf").trim();
                response.getWriter().println(value);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String value = request.getParameter("asdf").trim(); /* FLAW: does not handle case where asdf was not specified in request */
            response.getWriter().println(value);

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
