/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__fromDB_subtract_54c.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: fromDB Read data from a database connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: subtract
 *    GoodSink: Ensure there will not be an underflow before performing the subtraction
 *    BadSink : Unchecked subtraction can lead to underflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__fromDB_subtract_54c
{

    public void bad_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__fromDB_subtract_54d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__fromDB_subtract_54d()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__fromDB_subtract_54d()).goodB2G_sink(data );
    }
}
