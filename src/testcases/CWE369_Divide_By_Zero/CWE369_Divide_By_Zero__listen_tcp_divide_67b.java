/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__listen_tcp_divide_67b.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_By_Zero__listen_tcp_divide_67b
{

    public void bad_sink(CWE369_Divide_By_Zero__listen_tcp_divide_67a.Container data_container ) throws Throwable
    {
        int data = data_container.a;

        /* POTENTIAL FLAW: Zero denominator will cause an issue.  An integer division will
        result in an exception. */
        IO.writeLine("bad: 100/" + String.valueOf(data) + " = " + (100 / data) + "\n");

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE369_Divide_By_Zero__listen_tcp_divide_67a.Container data_container ) throws Throwable
    {
        int data = data_container.a;

        /* POTENTIAL FLAW: Zero denominator will cause an issue.  An integer division will
        result in an exception. */
        IO.writeLine("bad: 100/" + String.valueOf(data) + " = " + (100 / data) + "\n");

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE369_Divide_By_Zero__listen_tcp_divide_67a.Container data_container ) throws Throwable
    {
        int data = data_container.a;

        /* FIX: test for a zero denominator */
        if( data != 0 )
        {
            IO.writeLine("100/" + String.valueOf(data) + " = " + (100 / data) + "\n");
        }
        else
        {
            IO.writeLine("This would result in a divide by zero");
        }

    }
}
