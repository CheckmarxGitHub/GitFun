/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__getParameter_Servlet_trim_19.java
Label Definition File: CWE690_NULL_Deref_from_Return.label.xml
Template File: sources-sinks-19.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource: getParameter_Servlet Set data to return of getParameter_Servlet
* GoodSource: Set data to fixed, non-null String
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__getParameter_Servlet_trim_19 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data may be set to null */
        data = request.getParameter("CWE690");

        {

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();

            IO.writeLine(sOut);

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();

            IO.writeLine(sOut);

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* POTENTIAL FLAW: data may be set to null */
            data = request.getParameter("CWE690");

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();

            IO.writeLine(sOut);

        }
    }

    /* goodB2G() - use badsource and goodsink by switching statements around return */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: data may be set to null */
        data = request.getParameter("CWE690");

        {

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();

            IO.writeLine(sOut);

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
