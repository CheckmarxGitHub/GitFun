/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_PropertiesFile_51a.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-51a.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: PropertiesFile Read a value from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * BadSink: Servlet querystring parameter not sanitized
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE80_XSS;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE80_XSS__Servlet_PropertiesFile_51a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        (new CWE80_XSS__Servlet_PropertiesFile_51b()).bad_sink(data , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE80_XSS__Servlet_PropertiesFile_51b()).goodG2B_sink(data , request, response );
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
