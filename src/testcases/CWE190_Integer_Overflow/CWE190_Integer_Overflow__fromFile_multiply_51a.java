/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__fromFile_multiply_51a.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-51a.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: fromFile Read data from file
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before performing the multiplication
 *    BadSink : Unchecked multiplication, which can lead to overflow
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE190_Integer_Overflow__fromFile_multiply_51a extends AbstractTestCase
{

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

        (new CWE190_Integer_Overflow__fromFile_multiply_51b()).bad_sink(data  );
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

        (new CWE190_Integer_Overflow__fromFile_multiply_51b()).goodG2B_sink(data  );
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

        (new CWE190_Integer_Overflow__fromFile_multiply_51b()).goodB2G_sink(data  );
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
