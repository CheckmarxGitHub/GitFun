/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__random_modulo_54d.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_By_Zero__random_modulo_54d
{

    public void bad_sink(int data ) throws Throwable
    {
        (new CWE369_Divide_By_Zero__random_modulo_54e()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {
        (new CWE369_Divide_By_Zero__random_modulo_54e()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {
        (new CWE369_Divide_By_Zero__random_modulo_54e()).goodB2G_sink(data );
    }
}