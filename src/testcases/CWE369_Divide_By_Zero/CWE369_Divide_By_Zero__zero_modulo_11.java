/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__zero_modulo_11.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-11.tmpl.java
*/
/*
* @description
* CWE: 369 Divide by zero
* BadSource: zero Set data to a hardcoded value of zero
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: modulo
*    GoodSink: Check for zero before modulo
*    BadSink : Modulo by a value that may be zero
* Flow Variant: 11 Control flow: if(IO.static_returns_t()) and if(IO.static_returns_f())
*
* */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_By_Zero__zero_modulo_11 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;
        if(IO.static_returns_t())
        {
            data = 0; /* POTENTIAL FLAW: data is set to zero */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_t())
        {
            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_returns_t() to IO.static_returns_f() */
    private void goodG2B1() throws Throwable
    {
        int data;
        if(IO.static_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = 0; /* POTENTIAL FLAW: data is set to zero */
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_t())
        {
            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int data;
        if(IO.static_returns_t())
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = 0; /* POTENTIAL FLAW: data is set to zero */

        }
        if(IO.static_returns_t())
        {
            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_returns_t() to IO.static_returns_f() */
    private void goodB2G1() throws Throwable
    {
        int data;
        if(IO.static_returns_t())
        {
            data = 0; /* POTENTIAL FLAW: data is set to zero */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else {

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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int data;
        if(IO.static_returns_t())
        {
            data = 0; /* POTENTIAL FLAW: data is set to zero */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_t())
        {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
            result in an exception.  */
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
