/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__undefinedValueServlet_04.java
Label Definition File: CWE476_NULL_Pointer_Dereference.point.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* Sinks: undefinedValueServlet
*    GoodSink: checks for null before accessing the parameter
*    BadSink : assumes the parameter has been defined
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE476_NULL_Pointer_Dereference__undefinedValueServlet_04 extends AbstractTestCaseServlet
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

    /* good1() changes private_final_t to private_final_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_final_f)
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
        if(private_final_t)
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
