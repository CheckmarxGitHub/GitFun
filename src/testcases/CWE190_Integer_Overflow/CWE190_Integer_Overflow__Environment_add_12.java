/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__Environment_add_12.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: Environment Read data from an environment variable
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: add
*    GoodSink: Ensure there will not be an overflow before performing the addition
*    BadSink : Unchecked addition, which can lead to overflow
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__Environment_add_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;
        if(IO.static_returns_t_or_f())
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

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_t_or_f())
        {
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        else {

            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too large to perform addition.");
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        int data;
        if(IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        if(IO.static_returns_t_or_f())
        {
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        else {

            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);

            IO.writeLine("result: " + result);

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G() throws Throwable
    {
        int data;
        if(IO.static_returns_t_or_f())
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
        if(IO.static_returns_t_or_f())
        {
            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform addition.");
            }
        }
        else {

            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */

            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too large to perform addition.");
            }

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
