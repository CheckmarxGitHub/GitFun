/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__getParameterServlet_multiply_53d.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-53d.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before performing the multiplication
 *    BadSink : Unchecked multiplication, which can lead to overflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__getParameterServlet_multiply_53d
{

    public void bad_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data < 0)   /* ensure we don't have an overflow */
        {
            /* POTENTIAL FLAW: if (data*valueToMult) < MIN_VALUE, this will overflow */
            int result = (data * valueToMult);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data < 0)   /* ensure we don't have an overflow */
        {
            /* POTENTIAL FLAW: if (data*valueToMult) < MIN_VALUE, this will overflow */
            int result = (data * valueToMult);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data < 0)   /* ensure we don't have an overflow */
        {
            int result = 0;
            /* FIX: Add a check to prevent an underflow from occurring */
            if (data >= (Integer.MIN_VALUE/valueToMult))
            {
                result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too small to perform multiplication.");
            }
        }

    }
}
