/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_71a.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-71a.tmpl.java
*/
/*
 * @description
 * CWE: 321 Hard coded crypto key
 * BadSource:  hardcoded key
 * GoodSource: read key from console
 * Sinks:
 *    BadSink : use data as a key
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE321_Hard_Coded_Cryptographic_Key;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.math.BigInteger;
import java.util.Properties;

public class CWE321_Hard_Coded_Cryptographic_Key__basic_71a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: hardcoded key */
        data = "23 ~j;asn!@#/>as";

        (new CWE321_Hard_Coded_Cryptographic_Key__basic_71b()).bad_sink((Object)data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_gsrc = java.util.logging.Logger.getLogger("local-logger");

        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;

        data = ""; /* init data */

        try
        {
            inread2 = new InputStreamReader(System.in);
            bufread2 = new BufferedReader(inread2);

            /* FIX: read key from console */
            data = bufread2.readLine();
        }
        catch(IOException e)
        {
            log_gsrc.warning("Error reading from console");
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
                log_gsrc.warning("Error closing bufread2");
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
                    log_gsrc.warning("Error closing inread2");
                }
            }
        }

        (new CWE321_Hard_Coded_Cryptographic_Key__basic_71b()).goodG2B_sink((Object)data  );
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
