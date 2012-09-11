/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Properties_getProperty_equals_42.java
Label Definition File: CWE690_NULL_Deref_from_Return.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: Properties_getProperty Set data to return of Properties.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: equals
 *    GoodSink: Call equals() on string literal (that is not null)
 *    BadSink : Call equals() on possibly null object
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.Properties;

public class CWE690_NULL_Deref_from_Return__Properties_getProperty_equals_42 extends AbstractTestCase
{

    private String bad_source() throws Throwable
    {
        String data;

        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        FileInputStream finstrm2 = null;
        String propFileName = "./CWE690_NULL_Deref_from_Return__basic.properties";
        try
        {
            finstrm2 = new FileInputStream(propFileName);
            Properties p = new Properties();
            p.load(finstrm2);

            /* POTENTIAL FLAW: data may be set to null */
            data = p.getProperty("CWE690");
        }
        catch( IOException ioe )
        {
            IO.writeLine("Could not open properties file: " + propFileName);
            data = ""; /* ensure that data is initialized */
        }
        finally
        {
            try
            {
                if( finstrm2 != null )
                {
                    finstrm2.close();
                }
            }
            catch( IOException e )
            {
                log2.warning("Error closing finstrm2");
            }
        }

        return data;
    }

    public void bad() throws Throwable
    {
        String data = bad_source();

        /* POTENTIAL FLAW: data could be null */
        if(data.equals("CWE690"))
        {
            IO.writeLine("data is CWE690");
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private String goodG2B_source() throws Throwable
    {
        String data;

        /* FIX: Set data to a fixed, non-null String */
        data = "CWE690";

        return data;
    }

    private void goodG2B() throws Throwable
    {
        String data = goodG2B_source();

        /* POTENTIAL FLAW: data could be null */
        if(data.equals("CWE690"))
        {
            IO.writeLine("data is CWE690");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private String goodB2G_source() throws Throwable
    {
        String data;

        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        FileInputStream finstrm2 = null;
        String propFileName = "./CWE690_NULL_Deref_from_Return__basic.properties";
        try
        {
            finstrm2 = new FileInputStream(propFileName);
            Properties p = new Properties();
            p.load(finstrm2);

            /* POTENTIAL FLAW: data may be set to null */
            data = p.getProperty("CWE690");
        }
        catch( IOException ioe )
        {
            IO.writeLine("Could not open properties file: " + propFileName);
            data = ""; /* ensure that data is initialized */
        }
        finally
        {
            try
            {
                if( finstrm2 != null )
                {
                    finstrm2.close();
                }
            }
            catch( IOException e )
            {
                log2.warning("Error closing finstrm2");
            }
        }

        return data;
    }

    private void goodB2G() throws Throwable
    {
        String data = goodB2G_source();

        /* FIX: call equals() on string literal (that is not null) */
        if("CWE690".equals(data))
        {
            IO.writeLine("data is CWE690");
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
