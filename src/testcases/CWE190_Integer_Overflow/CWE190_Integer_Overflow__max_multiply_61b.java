/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__max_multiply_61b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the maximum value for int
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before performing the multiplication
 *    BadSink : Unchecked multiplication, which can lead to overflow
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE190_Integer_Overflow__max_multiply_61b
{

    public int bad_source() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Use the maximum value for this type */
        data = Integer.MAX_VALUE;

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public int goodG2B_source() throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public int goodB2G_source() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Use the maximum value for this type */
        data = Integer.MAX_VALUE;

        return data;
    }
}
