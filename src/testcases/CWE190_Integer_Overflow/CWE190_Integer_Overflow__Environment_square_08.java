/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__Environment_square_08.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-08.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: Environment Read data from an environment variable
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: square
*    GoodSink: Ensure there will not be an overflow before performing the squaring operation
*    BadSink : Unchecked squaring operation, which can lead to overflow
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

import java.lang.Math;

public class CWE190_Integer_Overflow__Environment_square_08 extends AbstractTestCase
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            /* get environment variable ADD */
            String s_data = System.getenv("ADD");
            try
            {
                data = Integer.parseInt(s_data.trim());
            }
            catch( NumberFormatException nfe )
            {
                log_bad.warning("Error with number parsing");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
            int result = (data * data);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int result = 0;

            /* FIX: Add a check to prevent an overflow from occurring
             * NOTE: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE so we must ensure the random value in
             *       data is not equal to Integer.MIN_VALUE */
            if ((Math.abs(data) != Integer.MIN_VALUE) && (Math.abs(data) <= (int)Math.sqrt(Integer.MAX_VALUE)))
            {
                result = (data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too large to perform squaring.");
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_returns_t() to private_returns_f() */
    private void goodG2B1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            /* get environment variable ADD */
            String s_data = System.getenv("ADD");
            try
            {
                data = Integer.parseInt(s_data.trim());
            }
            catch( NumberFormatException nfe )
            {
                log_bad.warning("Error with number parsing");
            }
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
            int result = (data * data);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int result = 0;

            /* FIX: Add a check to prevent an overflow from occurring
             * NOTE: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE so we must ensure the random value in
             *       data is not equal to Integer.MIN_VALUE */
            if ((Math.abs(data) != Integer.MIN_VALUE) && (Math.abs(data) <= (int)Math.sqrt(Integer.MAX_VALUE)))
            {
                result = (data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too large to perform squaring.");
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
            int result = (data * data);
            IO.writeLine("result: " + result);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int result = 0;

            /* FIX: Add a check to prevent an overflow from occurring
             * NOTE: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE so we must ensure the random value in
             *       data is not equal to Integer.MIN_VALUE */
            if ((Math.abs(data) != Integer.MIN_VALUE) && (Math.abs(data) <= (int)Math.sqrt(Integer.MAX_VALUE)))
            {
                result = (data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too large to perform squaring.");
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_returns_t() to private_returns_f() */
    private void goodB2G1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            /* get environment variable ADD */
            String s_data = System.getenv("ADD");
            try
            {
                data = Integer.parseInt(s_data.trim());
            }
            catch( NumberFormatException nfe )
            {
                log_bad.warning("Error with number parsing");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
            int result = (data * data);
            IO.writeLine("result: " + result);
        }
        else {

            int result = 0;

            /* FIX: Add a check to prevent an overflow from occurring
             * NOTE: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE so we must ensure the random value in
             *       data is not equal to Integer.MIN_VALUE */
            if ((Math.abs(data) != Integer.MIN_VALUE) && (Math.abs(data) <= (int)Math.sqrt(Integer.MAX_VALUE)))
            {
                result = (data * data);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too large to perform squaring.");
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            /* get environment variable ADD */
            String s_data = System.getenv("ADD");
            try
            {
                data = Integer.parseInt(s_data.trim());
            }
            catch( NumberFormatException nfe )
            {
                log_bad.warning("Error with number parsing");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            int result = 0;
            /* FIX: Add a check to prevent an overflow from occurring
             * NOTE: Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE so we must ensure the random value in
             *       data is not equal to Integer.MIN_VALUE */
            if ((Math.abs(data) != Integer.MIN_VALUE) && (Math.abs(data) <= (int)Math.sqrt(Integer.MAX_VALUE)))
            {
                result = (data * data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform squaring.");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: if (data*data) > MAX_VALUE, this will overflow */
            int result = (data * data);

            IO.writeLine("result: " + result);

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
