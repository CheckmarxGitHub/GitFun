/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__getParameter_Servlet_trim_07.java
Label Definition File: CWE690_NULL_Deref_from_Return.label.xml
Template File: sources-sinks-07.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource: getParameter_Servlet Set data to return of getParameter_Servlet
* GoodSource: Set data to fixed, non-null String
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__getParameter_Servlet_trim_07 extends AbstractTestCaseServlet
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* POTENTIAL FLAW: data may be set to null */
            data = request.getParameter("CWE690");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_five==5 to private_five!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: data may be set to null */
            data = request.getParameter("CWE690");
        }
        else {

            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: data may be set to null */
            data = request.getParameter("CWE690");

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_five==5 to private_five!=5 */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* POTENTIAL FLAW: data may be set to null */
            data = request.getParameter("CWE690");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }
        else {

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* POTENTIAL FLAW: data may be set to null */
            data = request.getParameter("CWE690");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Set data to a fixed, non-null String */
            data = "CWE690";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();

            IO.writeLine(sOut);

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
