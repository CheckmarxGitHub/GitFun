/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__PropertiesFile_13.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-13.tmpl.java
*/
/*
* @description
* CWE: 23 Relative Path Traversal
* BadSource: PropertiesFile Read a value from a .properties file (in property named data)
* GoodSource: A hardcoded string
* BadSink: readFile no validation
* Flow Variant: 13 Control flow: if(IO.static_final_five==5) and if(IO.static_final_five!=5)
*
* */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE23_Relative_Path_Traversal__PropertiesFile_13 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;
        if(IO.static_final_five==5)
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

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        String root = "C:\\uploads\\";
        /* POTENTIAL FLAW: no validation of concatenated value */
        File fIn = new File(root + data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    /* goodG2B1() - use goodsource and badsink by changing IO.static_final_five==5 to IO.static_final_five!=5 */
    private void goodG2B1() throws Throwable
    {
        String data;
        if(IO.static_final_five!=5)
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

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }

        String root = "C:\\uploads\\";
        /* POTENTIAL FLAW: no validation of concatenated value */
        File fIn = new File(root + data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if(IO.static_final_five==5)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
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

        String root = "C:\\uploads\\";
        /* POTENTIAL FLAW: no validation of concatenated value */
        File fIn = new File(root + data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
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
