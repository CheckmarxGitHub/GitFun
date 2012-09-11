/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__PropertiesFile_subtract_12.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: PropertiesFile Read a value from a .properties file
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: subtract
*    GoodSink: Ensure there will not be an underflow before performing the subtraction
*    BadSink : Unchecked subtraction can lead to underflow
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__PropertiesFile_subtract_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;
        if(IO.static_returns_t_or_f())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            /* retrieve the "pid" property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                String s_data = props.getProperty("pid");
                data = Integer.parseInt(s_data.trim());
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            catch( NumberFormatException nfe )
            {
                log_bad.warning("Error with number parsing");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
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
            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */
            /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
            int result = (data - valueToSub);
            IO.writeLine("result: " + result);
        }
        else {

            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */
            int result = 0;

            /* FIX: Add a check to prevent an underflow from occurring */
            if (data >= (Integer.MIN_VALUE+valueToSub))
            {
                result = (data - valueToSub);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too small to perform subtraction.");
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
            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */
            /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
            int result = (data - valueToSub);
            IO.writeLine("result: " + result);
        }
        else {

            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

            /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
            int result = (data - valueToSub);

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
            /* retrieve the "pid" property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                String s_data = props.getProperty("pid");
                data = Integer.parseInt(s_data.trim());
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            catch( NumberFormatException nfe )
            {
                log_bad.warning("Error with number parsing");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
            }
        }
        else {

            Logger log_bad = Logger.getLogger("local-logger");

            /* init data */
            data = -1;

            /* retrieve the "pid" property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);

                String s_data = props.getProperty("pid");
                data = Integer.parseInt(s_data.trim());
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            catch( NumberFormatException nfe )
            {
                log_bad.warning("Error with number parsing");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( finstr != null )
                    {
                        finstr.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
            }

        }
        if(IO.static_returns_t_or_f())
        {
            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */
            int result = 0;
            /* FIX: Add a check to prevent an underflow from occurring */
            if (data >= (Integer.MIN_VALUE+valueToSub))
            {
                result = (data - valueToSub);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too small to perform subtraction.");
            }
        }
        else {

            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */
            int result = 0;

            /* FIX: Add a check to prevent an underflow from occurring */
            if (data >= (Integer.MIN_VALUE+valueToSub))
            {
                result = (data - valueToSub);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too small to perform subtraction.");
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
