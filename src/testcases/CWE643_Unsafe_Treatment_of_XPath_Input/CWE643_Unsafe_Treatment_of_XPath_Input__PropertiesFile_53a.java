/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Unsafe_Treatment_of_XPath_Input__PropertiesFile_53a.java
Label Definition File: CWE643_Unsafe_Treatment_of_XPath_Input.label.xml
Template File: sources-sinks-53a.tmpl.java
*/
/*
 * @description
 * CWE: 643 Unsafe Treatment of XPath Input
 * BadSource: PropertiesFile Read a value from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: unvalidatedXPath
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE643_Unsafe_Treatment_of_XPath_Input;

import testcasesupport.*;

import java.io.*;
import javax.xml.xpath.*;
import javax.servlet.http.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE643_Unsafe_Treatment_of_XPath_Input__PropertiesFile_53a extends AbstractTestCase
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

        (new CWE643_Unsafe_Treatment_of_XPath_Input__PropertiesFile_53b()).bad_sink(data );
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

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE643_Unsafe_Treatment_of_XPath_Input__PropertiesFile_53b()).goodG2B_sink(data );
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

        (new CWE643_Unsafe_Treatment_of_XPath_Input__PropertiesFile_53b()).goodB2G_sink(data );
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
