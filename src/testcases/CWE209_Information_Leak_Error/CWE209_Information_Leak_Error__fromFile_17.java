/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__fromFile_17.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* BadSource: fromFile Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* Sinks: stackDump
*    GoodSink: Generic error message
*    BadSink : Error causes stack dump
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE209_Information_Leak_Error__fromFile_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

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

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statements with the one in the first for statement */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try
            {
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
            finally
            {
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
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
            }
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the second and third for statements */
    private void goodB2G() throws Throwable
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

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
            }
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
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
