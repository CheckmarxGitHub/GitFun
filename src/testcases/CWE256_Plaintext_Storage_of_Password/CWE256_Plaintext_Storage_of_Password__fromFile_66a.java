/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__fromFile_66a.java
Label Definition File: CWE256_Plaintext_Storage_of_Password.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
 * BadSource: fromFile Read data from a file (named C:\data.txt)
 * GoodSource: Read data from the console using readLine
 * Sinks: basic
 *    GoodSink: Use decrypted data as password to connect to DB
 *    BadSink : Use data as password to connect to DB
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE256_Plaintext_Storage_of_Password;

import testcasesupport.*;

import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE256_Plaintext_Storage_of_Password__fromFile_66a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        File f = new File("C:\\data.txt");
        BufferedReader buffread = null;
        FileReader fread = null;
        try {
            /* read string from file into data */
            char[] readIn = new char[(new Long(f.length())).intValue()];
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

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE256_Plaintext_Storage_of_Password__fromFile_66b()).bad_sink(data_array  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        Logger log_good = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* read user input from console with readLine*/
        BufferedReader buffread_g = null;
        InputStreamReader instrread = null;
        try {
            instrread = new InputStreamReader(System.in);
            buffread_g = new BufferedReader(instrread);
            data = buffread_g.readLine();
        }
        catch( IOException ioe )
        {
            log_good.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread_g != null )
                {
                    buffread_g.close();
                }
            }
            catch( IOException ioe )
            {
                log_good.warning("Error closing buffread_g");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_good.warning("Error closing instrread");
                }
            }
        }

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE256_Plaintext_Storage_of_Password__fromFile_66b()).goodG2B_sink(data_array  );
    }

    /* goodB2G() - use badsource and goodsink */
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
            char[] readIn = new char[(new Long(f.length())).intValue()];
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

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE256_Plaintext_Storage_of_Password__fromFile_66b()).goodB2G_sink(data_array  );
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
