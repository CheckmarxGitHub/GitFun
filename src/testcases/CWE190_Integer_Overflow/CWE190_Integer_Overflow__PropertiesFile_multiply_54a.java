/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__PropertiesFile_multiply_54a.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-54a.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: PropertiesFile Read a value from a .properties file
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before performing the multiplication
 *    BadSink : Unchecked multiplication, which can lead to overflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
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

public class CWE190_Integer_Overflow__PropertiesFile_multiply_54a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;

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

        (new CWE190_Integer_Overflow__PropertiesFile_multiply_54b()).bad_sink(data );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        (new CWE190_Integer_Overflow__PropertiesFile_multiply_54b()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

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

        (new CWE190_Integer_Overflow__PropertiesFile_multiply_54b()).goodB2G_sink(data );
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
