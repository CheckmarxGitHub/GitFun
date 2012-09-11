/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__fromFile_31.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE606_Unchecked_Loop_Condition__fromFile_31 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data_copy;
        {
            String data;

            Logger log_bad = Logger.getLogger("local-logger");

            data = ""; /* init data */

            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try {
                /* read string from file into data */
                fread = new FileReader(f);
                buffread = new BufferedReader(fread);

                data = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file\
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

            data_copy = data;
        }
        {
            String data = data_copy;

            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }

            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data_copy;
        {
            String data;

            data = "5";

            data_copy = data;
        }
        {
            String data = data_copy;

            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }

            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }

        }
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data_copy;
        {
            String data;

            Logger log_bad = Logger.getLogger("local-logger");

            data = ""; /* init data */

            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try {
                /* read string from file into data */
                fread = new FileReader(f);
                buffread = new BufferedReader(fread);

                data = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file\
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

            data_copy = data;
        }
        {
            String data = data_copy;

            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }

            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }

        }
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
