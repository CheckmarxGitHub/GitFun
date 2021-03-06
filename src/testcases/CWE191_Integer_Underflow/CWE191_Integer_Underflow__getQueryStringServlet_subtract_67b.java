/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__getQueryStringServlet_subtract_67b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: subtract
 *    GoodSink: Ensure there will not be an underflow before performing the subtraction
 *    BadSink : Unchecked subtraction can lead to underflow
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__getQueryStringServlet_subtract_67b
{

    public void bad_sink(CWE191_Integer_Underflow__getQueryStringServlet_subtract_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_container.a;

        int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

        /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
        int result = (data - valueToSub);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE191_Integer_Underflow__getQueryStringServlet_subtract_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_container.a;

        int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

        /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
        int result = (data - valueToSub);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE191_Integer_Underflow__getQueryStringServlet_subtract_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_container.a;

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
