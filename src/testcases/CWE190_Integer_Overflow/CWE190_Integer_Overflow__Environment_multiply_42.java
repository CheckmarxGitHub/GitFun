/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__Environment_multiply_42.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before performing the multiplication
 *    BadSink : Unchecked multiplication, which can lead to overflow
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__Environment_multiply_42 extends AbstractTestCase
{

    private int bad_source() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        /* get environment variable ADD */
        String s_data = System.getenv("ADD");
        try {
            data = Integer.parseInt(s_data.trim());
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }

        return data;
    }

    public void bad() throws Throwable
    {
        int data = bad_source();

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data > 0)   /* ensure we don't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
            int result = (data * valueToMult);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private int goodG2B_source() throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    private void goodG2B() throws Throwable
    {
        int data = goodG2B_source();

        int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

        if(data > 0)   /* ensure we don't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
            int result = (data * valueToMult);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private int goodB2G_source() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        /* get environment variable ADD */
        String s_data = System.getenv("ADD");
        try {
            data = Integer.parseInt(s_data.trim());
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }

        return data;
    }

    private void goodB2G() throws Throwable
    {
        int data = goodB2G_source();

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

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
