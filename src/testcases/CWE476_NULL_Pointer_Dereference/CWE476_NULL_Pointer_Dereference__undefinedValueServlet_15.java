/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__undefinedValueServlet_15.java
Label Definition File: CWE476_NULL_Pointer_Dereference.point.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* Sinks: undefinedValueServlet
*    GoodSink: checks for null before accessing the parameter
*    BadSink : assumes the parameter has been defined
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE476_NULL_Pointer_Dereference__undefinedValueServlet_15 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            String value = request.getParameter("asdf").trim(); /* FLAW: does not handle case where asdf was not specified in request */
            response.getWriter().println(value);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            if (request.getParameter("asdf") != null) /* FIX: verifies that parameter exists */
            {
                String value = request.getParameter("asdf").trim();
                response.getWriter().println(value);
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
            String value = request.getParameter("asdf").trim(); /* FLAW: does not handle case where asdf was not specified in request */
            response.getWriter().println(value);
        }
        break;
        default:
        {
            if (request.getParameter("asdf") != null) /* FIX: verifies that parameter exists */
            {
                String value = request.getParameter("asdf").trim();
                response.getWriter().println(value);
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
            if (request.getParameter("asdf") != null) /* FIX: verifies that parameter exists */
            {
                String value = request.getParameter("asdf").trim();
                response.getWriter().println(value);
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String value = request.getParameter("asdf").trim(); /* FLAW: does not handle case where asdf was not specified in request */
            response.getWriter().println(value);
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
