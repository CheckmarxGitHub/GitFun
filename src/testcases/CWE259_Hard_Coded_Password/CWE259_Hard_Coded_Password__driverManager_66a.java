/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_66a.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-66a.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Hardcoded password in String
 * GoodSource: Password is read from stdin
 * Sinks: driverManager
 *    BadSink : password used in database connection
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE259_Hard_Coded_Password__driverManager_66a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        data = "pass";

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE259_Hard_Coded_Password__driverManager_66b()).bad_sink(data_array  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good_source = java.util.logging.Logger.getLogger("local-logger");

        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;

        Properties prop = new Properties();
        IO.writeLine("Enter the password: ");

        data = "";

        try
        {
            inread2 = new InputStreamReader(System.in);
            bufread2 = new BufferedReader(inread2);
            /* FIX: password is read from stdin */
            data = bufread2.readLine();
        }
        catch(Exception e)
        {
            log_good_source.warning("Exception in try");
        }
        finally
        {
            try
            {
                if( bufread2 != null )
                {
                    bufread2.close();
                }
            }
            catch( IOException e )
            {
                log_good_source.warning("Error closing bufread2");
            }
            finally
            {
                try
                {
                    if( inread2 != null )
                    {
                        inread2.close();
                    }
                }
                catch( IOException e )
                {
                    log_good_source.warning("Error closing inread2");
                }
            }
        }

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE259_Hard_Coded_Password__driverManager_66b()).goodG2B_sink(data_array  );
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
