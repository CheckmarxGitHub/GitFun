/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__getCookiesServlet_61a.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE606_Unchecked_Loop_Condition__getCookiesServlet_61a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE606_Unchecked_Loop_Condition__getCookiesServlet_61b()).bad_source(request, response);

        int loopNum;
        try
        {
            loopNum = Integer.parseInt(data);
        }
        catch (NumberFormatException nfe)
        {
            IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
            loopNum = 1;
        }

        for(int i=0; i < loopNum; i++)
        {
            /* POTENTIAL FLAW: user supplied input used for loop counter test */
            IO.writeLine("hello world");
        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE606_Unchecked_Loop_Condition__getCookiesServlet_61b()).goodG2B_source(request, response);

        int loopNum;
        try
        {
            loopNum = Integer.parseInt(data);
        }
        catch (NumberFormatException nfe)
        {
            IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
            loopNum = 1;
        }

        for(int i=0; i < loopNum; i++)
        {
            /* POTENTIAL FLAW: user supplied input used for loop counter test */
            IO.writeLine("hello world");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE606_Unchecked_Loop_Condition__getCookiesServlet_61b()).goodB2G_source(request, response);

        int loopNum;
        try
        {
            loopNum = Integer.parseInt(data);
        }
        catch (NumberFormatException nfe)
        {
            IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
            loopNum = 1;
        }

        /* FIX: loop number thresholds validated */
        if (loopNum >= 0 && loopNum <= 5)
        {
            for(int i=0; i < loopNum; i++)
            {
                IO.writeLine("hello world");
            }
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
