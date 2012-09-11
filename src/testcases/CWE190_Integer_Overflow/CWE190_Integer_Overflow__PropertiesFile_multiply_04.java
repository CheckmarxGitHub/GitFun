/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__PropertiesFile_multiply_04.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-04.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: PropertiesFile Read a value from a .properties file
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: multiply
*    GoodSink: Ensure there will not be an overflow before performing the multiplication
*    BadSink : Unchecked multiplication, which can lead to overflow
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__PropertiesFile_multiply_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
                int result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

            if(data > 0)   /* ensure we don't have an underflow */
            {
                int result = 0;
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data <= (Integer.MAX_VALUE/valueToMult))
                {
                    result = (data * valueToMult);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("Input value is too large to perform multiplication.");
                }
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_final_t to private_final_f */
    private void goodG2B1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
                int result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

            if(data > 0)   /* ensure we don't have an underflow */
            {
                int result = 0;
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data <= (Integer.MAX_VALUE/valueToMult))
                {
                    result = (data * valueToMult);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("Input value is too large to perform multiplication.");
                }
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
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
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
                int result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

            if(data > 0)   /* ensure we don't have an underflow */
            {
                int result = 0;
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data <= (Integer.MAX_VALUE/valueToMult))
                {
                    result = (data * valueToMult);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("Input value is too large to perform multiplication.");
                }
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_final_t to private_final_f */
    private void goodB2G1() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
                int result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }
        }
        else {

            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

            if(data > 0)   /* ensure we don't have an underflow */
            {
                int result = 0;
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data <= (Integer.MAX_VALUE/valueToMult))
                {
                    result = (data * valueToMult);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("Input value is too large to perform multiplication.");
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        int data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                int result = 0;
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data <= (Integer.MAX_VALUE/valueToMult))
                {
                    result = (data * valueToMult);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("Input value is too large to perform multiplication.");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */

            if(data > 0)   /* ensure we don't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
                int result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }

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
