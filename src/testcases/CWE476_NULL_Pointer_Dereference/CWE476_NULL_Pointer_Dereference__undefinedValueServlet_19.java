/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__undefinedValueServlet_19.java
Label Definition File: CWE476_NULL_Pointer_Dereference.point.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* Sinks: undefinedValueServlet
*    GoodSink: checks for null before accessing the parameter
*    BadSink : assumes the parameter has been defined
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE476_NULL_Pointer_Dereference__undefinedValueServlet_19 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        {

            String value = request.getParameter("asdf").trim(); /* FLAW: does not handle case where asdf was not specified in request */
            response.getWriter().println(value);

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            if (request.getParameter("asdf") != null) /* FIX: verifies that parameter exists */
            {
                String value = request.getParameter("asdf").trim();
                response.getWriter().println(value);
            }

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        {

            if (request.getParameter("asdf") != null) /* FIX: verifies that parameter exists */
            {
                String value = request.getParameter("asdf").trim();
                response.getWriter().println(value);
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            String value = request.getParameter("asdf").trim(); /* FLAW: does not handle case where asdf was not specified in request */
            response.getWriter().println(value);

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

