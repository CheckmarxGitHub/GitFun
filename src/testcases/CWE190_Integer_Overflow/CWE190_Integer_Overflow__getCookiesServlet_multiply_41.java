/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__getCookiesServlet_multiply_41.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before performing the multiplication
 *    BadSink : Unchecked multiplication, which can lead to overflow
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__getCookiesServlet_multiply_41 extends AbstractTestCaseServlet
{

    private void bad_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data > 0)   /* ensure we don't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
            int result = (data * valueToMult);
            IO.writeLine("result: " + result);
        }

    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init Data$ */
        data = -1;

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            String s_data = cookieSources[0].getValue();
            data = Integer.parseInt(s_data.trim());
        }

        bad_sink(data , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data > 0)   /* ensure we don't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
            int result = (data * valueToMult);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        goodG2B_sink(data , request, response );
    }

    private void goodB2G_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data > 0)   /* ensure we don't have an underflow */
        {
            int result = 0;
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE/valueToMult))
            {
                result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform multiplication.");
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init Data$ */
        data = -1;

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            String s_data = cookieSources[0].getValue();
            data = Integer.parseInt(s_data.trim());
        }

        goodB2G_sink(data , request, response );
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
