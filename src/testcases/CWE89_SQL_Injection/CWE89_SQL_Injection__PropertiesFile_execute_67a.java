/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__PropertiesFile_execute_67a.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: PropertiesFile Read a value from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: execute
 *    GoodSink: prepared sqlstatement, single
 *    BadSink : untrusted parameter value to raw insert sqlstatement
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__PropertiesFile_execute_67a extends AbstractTestCase
{

    static class Container
    {
        public String a;
    }

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

        Container data_container = new Container();
        data_container.a = data;
        (new CWE89_SQL_Injection__PropertiesFile_execute_67b()).bad_sink(data_container  );
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

        Container data_container = new Container();
        data_container.a = data;
        (new CWE89_SQL_Injection__PropertiesFile_execute_67b()).goodG2B_sink(data_container  );
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

        Container data_container = new Container();
        data_container.a = data;
        (new CWE89_SQL_Injection__PropertiesFile_execute_67b()).goodB2G_sink(data_container  );
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
