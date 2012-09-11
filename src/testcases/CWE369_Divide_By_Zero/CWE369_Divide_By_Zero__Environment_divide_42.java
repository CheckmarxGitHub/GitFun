/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__Environment_divide_42.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.util.logging.Logger;

public class CWE369_Divide_By_Zero__Environment_divide_42 extends AbstractTestCase
{

    private int bad_source() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        /* get environment variable ADD */
        String s_data = System.getenv("ADD");
        try {
            data = Integer.parseInt(s_data.trim());
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }

        return data;
    }

    public void bad() throws Throwable
    {
        int data = bad_source();

        /* POTENTIAL FLAW: Zero denominator will cause an issue.  An integer division will
        result in an exception. */
        IO.writeLine("bad: 100/" + String.valueOf(data) + " = " + (100 / data) + "\n");

    }

    /* goodG2B() - use goodsource and badsink */
    private int goodG2B_source() throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    private void goodG2B() throws Throwable
    {
        int data = goodG2B_source();

        /* POTENTIAL FLAW: Zero denominator will cause an issue.  An integer division will
        result in an exception. */
        IO.writeLine("bad: 100/" + String.valueOf(data) + " = " + (100 / data) + "\n");

    }

    /* goodB2G() - use badsource and goodsink */
    private int goodB2G_source() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        /* get environment variable ADD */
        String s_data = System.getenv("ADD");
        try {
            data = Integer.parseInt(s_data.trim());
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }

        return data;
    }

    private void goodB2G() throws Throwable
    {
        int data = goodB2G_source();

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

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
