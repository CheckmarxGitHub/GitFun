/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__console_readLine_add_52c.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before performing the addition
 *    BadSink : Unchecked addition, which can lead to overflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__console_readLine_add_52c
{

    public void bad_sink(int data ) throws Throwable
    {

        int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

        /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
        int result = (data + valueToAdd);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {

        int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

        /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
        int result = (data + valueToAdd);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {

        int result = 0;
        int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data <= (Integer.MAX_VALUE-valueToAdd))
        {
            result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        else {
            IO.writeLine("Input value is too large to perform addition.");
        }

    }
}
