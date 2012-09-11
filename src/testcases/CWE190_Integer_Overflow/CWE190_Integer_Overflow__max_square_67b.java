/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__max_square_67b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the maximum value for int
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before performing the squaring operation
 *    BadSink : Unchecked squaring operation, which can lead to overflow
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.lang.Math;

public class CWE190_Integer_Overflow__max_square_67b
{

    public void bad_sink(CWE190_Integer_Overflow__max_square_67a.Container data_container ) throws Throwable
    {
        int data = data_container.a;

        /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
        int result = (data * data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE190_Integer_Overflow__max_square_67a.Container data_container ) throws Throwable
    {
        int data = data_container.a;

        /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
        int result = (data * data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE190_Integer_Overflow__max_square_67a.Container data_container ) throws Throwable
    {
        int data = data_container.a;

        int result = 0;

        /* FIX: Add a check to prevent an overflow from occurring
         * NOTE: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE so we must ensure the random value in
         *       data is not equal to Integer.MIN_VALUE */
        if ((Math.abs(data) != Integer.MIN_VALUE) && (Math.abs(data) <= (int)Math.sqrt(Integer.MAX_VALUE)))
        {
            result = (data * data);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("Input value is too large to perform squaring.");
        }

    }
}
