/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__URLConnection_multiply_53c.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: URLConnection Read data from a web server with URLConnection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before performing the multiplication
 *    BadSink : Unchecked multiplication, which can lead to overflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__URLConnection_multiply_53c
{

    public void bad_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__URLConnection_multiply_53d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__URLConnection_multiply_53d()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__URLConnection_multiply_53d()).goodB2G_sink(data );
    }
}
