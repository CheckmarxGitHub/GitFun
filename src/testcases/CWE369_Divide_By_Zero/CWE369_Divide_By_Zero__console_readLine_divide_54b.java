/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__console_readLine_divide_54b.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_By_Zero__console_readLine_divide_54b
{

    public void bad_sink(int data ) throws Throwable
    {
        (new CWE369_Divide_By_Zero__console_readLine_divide_54c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {
        (new CWE369_Divide_By_Zero__console_readLine_divide_54c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {
        (new CWE369_Divide_By_Zero__console_readLine_divide_54c()).goodB2G_sink(data );
    }
}
