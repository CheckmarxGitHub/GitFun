/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__getParameterServlet_add_45.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before performing the addition
 *    BadSink : Unchecked addition, which can lead to overflow
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__getParameterServlet_add_45 extends AbstractTestCaseServlet
{

    private int bad_data;
    private int goodG2B_data;
    private int goodB2G_data;

    private void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = bad_data;

        int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

        /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
        int result = (data + valueToAdd);

        IO.writeLine("result: " + result);

    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init Data$ */
        data = -1;

        /* read parameter from request */
        String s_data = request.getParameter("name");
        data = Integer.parseInt(s_data.trim());

        bad_data = data;
        bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = goodG2B_data;

        int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

        /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
        int result = (data + valueToAdd);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        goodG2B_data = data;
        goodG2B_sink(request, response);
    }

    private void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = goodB2G_data;

        int result = 0;
        int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data <= (Integer.MAX_VALUE-valueToAdd))
        {
            result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("Input value is too large to perform addition.");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init Data$ */
        data = -1;

        /* read parameter from request */
        String s_data = request.getParameter("name");
        data = Integer.parseInt(s_data.trim());

        goodB2G_data = data;
        goodB2G_sink(request, response);
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
