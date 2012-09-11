/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__fromDB_modulo_66b.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: fromDB Read data from a database connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_By_Zero__fromDB_modulo_66b
{

    public void bad_sink(int data_array[] ) throws Throwable
    {
        int data = data_array[2];

        /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
        result in an exception.  */
        IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data_array[] ) throws Throwable
    {
        int data = data_array[2];

        /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
        result in an exception.  */
        IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data_array[] ) throws Throwable
    {
        int data = data_array[2];

        /* FIX: test for a zero modulus */
        if( data != 0 )
        {
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else
        {
            IO.writeLine("This would result in a modulo by zero");
        }

    }
}
