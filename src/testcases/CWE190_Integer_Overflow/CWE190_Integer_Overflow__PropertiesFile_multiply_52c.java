/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__PropertiesFile_multiply_52c.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: PropertiesFile Read a value from a .properties file
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before performing the multiplication
 *    BadSink : Unchecked multiplication, which can lead to overflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__PropertiesFile_multiply_52c
{

    public void bad_sink(int data ) throws Throwable
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
    public void goodG2B_sink(int data ) throws Throwable
    {

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data > 0)   /* ensure we don't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
            int result = (data * valueToMult);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
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
}
