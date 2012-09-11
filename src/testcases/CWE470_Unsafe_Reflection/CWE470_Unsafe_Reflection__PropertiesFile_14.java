/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__PropertiesFile_14.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-14.tmpl.java
*/
/*
* @description
* CWE: 470 Unsafe Reflection
* BadSource: PropertiesFile Read a value from a .properties file (in property named data)
* GoodSource: Hardcoded class to load
* Sinks:
*    GoodSink: instantiate only certain fixed classes
*    BadSink : instantiate arbitrary class
* Flow Variant: 14 Control flow: if(IO.static_five==5) and if(IO.static_five!=5)
*
* */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__PropertiesFile_14 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "Testing.test";

        }
        if(IO.static_five==5)
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_five==5 to IO.static_five!=5 */
    private void goodG2B1() throws Throwable
    {
        String data;
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
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
        }
        else {

            data = "Testing.test";

        }
        if(IO.static_five==5)
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            data = "Testing.test";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

        }
        if(IO.static_five==5)
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_five==5 to IO.static_five!=5 */
    private void goodB2G1() throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "Testing.test";

        }
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* retrieve the property */
            Properties props = new Properties();
            FileInputStream finstr = null;
            try
            {
                finstr = new FileInputStream("../common/config.properties");
                props.load(finstr);
                data = props.getProperty("data");
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "Testing.test";

        }
        if(IO.static_five==5)
        {
            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
                    !data.equals("Test.test"))
            {
                return;
            }
            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
