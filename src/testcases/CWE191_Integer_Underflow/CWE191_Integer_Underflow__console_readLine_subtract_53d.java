/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__console_readLine_subtract_53d.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-53d.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: subtract
 *    GoodSink: Ensure there will not be an underflow before performing the subtraction
 *    BadSink : Unchecked subtraction can lead to underflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__console_readLine_subtract_53d
{

    public void bad_sink(int data ) throws Throwable
    {

        int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

        /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
        int result = (data - valueToSub);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {

        int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

        /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
        int result = (data - valueToSub);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
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
