/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__getCookiesServlet_multiply_67b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before performing the multiplication
 *    BadSink : Unchecked multiplication, which can lead to overflow
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__getCookiesServlet_multiply_67b
{

    public void bad_sink(CWE191_Integer_Underflow__getCookiesServlet_multiply_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_container.a;

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data < 0)   /* ensure we don't have an overflow */
        {
            /* POTENTIAL FLAW: if (data*valueToMult) < MIN_VALUE, this will overflow */
            int result = (data * valueToMult);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE191_Integer_Underflow__getCookiesServlet_multiply_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_container.a;

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data < 0)   /* ensure we don't have an overflow */
        {
            /* POTENTIAL FLAW: if (data*valueToMult) < MIN_VALUE, this will overflow */
            int result = (data * valueToMult);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE191_Integer_Underflow__getCookiesServlet_multiply_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_container.a;

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
