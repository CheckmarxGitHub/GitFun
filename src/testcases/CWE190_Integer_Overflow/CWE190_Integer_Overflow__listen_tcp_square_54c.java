/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__listen_tcp_square_54c.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before performing the squaring operation
 *    BadSink : Unchecked squaring operation, which can lead to overflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.lang.Math;

public class CWE190_Integer_Overflow__listen_tcp_square_54c
{

    public void bad_sink(int data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__listen_tcp_square_54d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__listen_tcp_square_54d()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__listen_tcp_square_54d()).goodB2G_sink(data );
    }
}
