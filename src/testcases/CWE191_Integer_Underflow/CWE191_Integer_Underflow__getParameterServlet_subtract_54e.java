/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__getParameterServlet_subtract_54e.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-54e.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: subtract
 *    GoodSink: Ensure there will not be an underflow before performing the subtraction
 *    BadSink : Unchecked subtraction can lead to underflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__getParameterServlet_subtract_54e
{

    public void bad_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

        /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
        int result = (data - valueToSub);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

        /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
        int result = (data - valueToSub);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */
        int result = 0;

        /* FIX: Add a check to prevent an underflow from occurring */
        if (data >= (Integer.MIN_VALUE+valueToSub))
        {
            result = (data - valueToSub);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("Input value is too small to perform subtraction.");
        }

    }
}
