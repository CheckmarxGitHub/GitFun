/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__PropertiesFile_71a.java
Label Definition File: CWE256_Plaintext_Storage_of_Password.label.xml
Template File: sources-sinks-71a.tmpl.java
*/
/*
 * @description
 * CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
 * BadSource: PropertiesFile Read data from a .properties file (from the property named data)
 * GoodSource: Read data from the console using readLine
 * Sinks: basic
 *    GoodSink: Use decrypted data as password to connect to DB
 *    BadSink : Use data as password to connect to DB
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE256_Plaintext_Storage_of_Password;

import testcasesupport.*;

import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE256_Plaintext_Storage_of_Password__PropertiesFile_71a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* retrieve the property */
        Properties props = new Properties();
        FileInputStream finstr = null;
        try {
            finstr = new FileInputStream("../common/config.properties");
            props.load(finstr);

            data = props.getProperty("data");
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
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

        (new CWE256_Plaintext_Storage_of_Password__PropertiesFile_71b()).bad_sink((Object)data  );
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

        (new CWE256_Plaintext_Storage_of_Password__PropertiesFile_71b()).goodG2B_sink((Object)data  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* retrieve the property */
        Properties props = new Properties();
        FileInputStream finstr = null;
        try {
            finstr = new FileInputStream("../common/config.properties");
            props.load(finstr);

            data = props.getProperty("data");
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
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

        (new CWE256_Plaintext_Storage_of_Password__PropertiesFile_71b()).goodB2G_sink((Object)data  );
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
