/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__min_subtract_61b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the minimum value for an int
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: subtract
 *    GoodSink: Ensure there will not be an underflow before performing the subtraction
 *    BadSink : Unchecked subtraction can lead to underflow
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE191_Integer_Underflow__min_subtract_61b
{

    public int bad_source() throws Throwable
    {
        int data;

        /* POTENTIAL FLAW: Use the minimum value for an int */
        data = Integer.MIN_VALUE;

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

        /* POTENTIAL FLAW: Use the minimum value for an int */
        data = Integer.MIN_VALUE;

        return data;
    }
}
