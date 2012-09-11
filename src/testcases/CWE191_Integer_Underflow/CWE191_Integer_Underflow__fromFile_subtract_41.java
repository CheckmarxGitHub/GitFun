/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__fromFile_subtract_41.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: fromFile Read data from file
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: subtract
 *    GoodSink: Ensure there will not be an underflow before performing the subtraction
 *    BadSink : Unchecked subtraction can lead to underflow
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__fromFile_subtract_41 extends AbstractTestCase
{

    private void bad_sink(int data ) throws Throwable
    {

        int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

        /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
        int result = (data - valueToSub);

        IO.writeLine("result: " + result);

    }

    public void bad() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        File f = new File("C:\\name.txt");
        BufferedReader buffread = null;
        FileReader fread = null;
        try {
            /* read string from file into data */
            char[] readIn = new char[(new Long(f.length())).intValue()];
            fread = new FileReader(f);
            buffread = new BufferedReader(fread);

            String s_data = buffread.readLine(); // This will be reading the first "line" of the file, which
            // could be very long if there are little or no newlines in the file\
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
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( fread != null )
                    {
                        fread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing fread");
                }
            }
        }

        bad_sink(data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2B_sink(int data ) throws Throwable
    {

        int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

        /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
        int result = (data - valueToSub);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        goodG2B_sink(data  );
    }

    private void goodB2G_sink(int data ) throws Throwable
    {

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        File f = new File("C:\\name.txt");
        BufferedReader buffread = null;
        FileReader fread = null;
        try {
            /* read string from file into data */
            char[] readIn = new char[(new Long(f.length())).intValue()];
            fread = new FileReader(f);
            buffread = new BufferedReader(fread);

            String s_data = buffread.readLine(); // This will be reading the first "line" of the file, which
            // could be very long if there are little or no newlines in the file\
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
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( fread != null )
                    {
                        fread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing fread");
                }
            }
        }

        goodB2G_sink(data  );
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
