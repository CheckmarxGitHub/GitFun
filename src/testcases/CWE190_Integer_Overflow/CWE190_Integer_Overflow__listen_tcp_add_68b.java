/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__listen_tcp_add_68b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before performing the addition
 *    BadSink : Unchecked addition, which can lead to overflow
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__listen_tcp_add_68b
{

    public void bad_sink() throws Throwable
    {
        int data = CWE190_Integer_Overflow__listen_tcp_add_68a.data;

        int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

        /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
        int result = (data + valueToAdd);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        int data = CWE190_Integer_Overflow__listen_tcp_add_68a.data;

        int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

        /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
        int result = (data + valueToAdd);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink() throws Throwable
    {
        int data = CWE190_Integer_Overflow__listen_tcp_add_68a.data;

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
