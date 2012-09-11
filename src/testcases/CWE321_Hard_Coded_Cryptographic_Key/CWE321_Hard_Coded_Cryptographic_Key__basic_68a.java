/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_68a.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 321 Hard coded crypto key
 * BadSource:  hardcoded key
 * GoodSource: read key from console
 * BadSink:  use data as a key
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE321_Hard_Coded_Cryptographic_Key;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.math.BigInteger;
import java.util.Properties;

public class CWE321_Hard_Coded_Cryptographic_Key__basic_68a extends AbstractTestCase
{

    public static String data;

    public void bad() throws Throwable
    {

        /* POTENTIAL FLAW: hardcoded key */
        data = "23 ~j;asn!@#/>as";

        (new CWE321_Hard_Coded_Cryptographic_Key__basic_68b()).bad_sink();
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {

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

        (new CWE321_Hard_Coded_Cryptographic_Key__basic_68b()).goodG2B_sink();
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
