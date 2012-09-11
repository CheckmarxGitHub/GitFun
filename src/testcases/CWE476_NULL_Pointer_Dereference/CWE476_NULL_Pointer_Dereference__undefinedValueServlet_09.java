/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__undefinedValueServlet_09.java
Label Definition File: CWE476_NULL_Pointer_Dereference.point.label.xml
Template File: point-flaw-09.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* Sinks: undefinedValueServlet
*    GoodSink: checks for null before accessing the parameter
*    BadSink : assumes the parameter has been defined
* Flow Variant: 09 Control flow: if(IO.static_final_t) and if(IO.static_final_f)
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE476_NULL_Pointer_Dereference__undefinedValueServlet_09 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (IO.static_final_t)
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

    /* good1() changes IO.static_final_t to IO.static_final_f */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(IO.static_final_f)
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
        if(IO.static_final_t)
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
