/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__PropertiesFile_subtract_54d.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: PropertiesFile Read a value from a .properties file
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

public class CWE191_Integer_Underflow__PropertiesFile_subtract_54d
{

    public void bad_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__PropertiesFile_subtract_54e()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__PropertiesFile_subtract_54e()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {
        (new CWE191_Integer_Underflow__PropertiesFile_subtract_54e()).goodB2G_sink(data );
    }
}
