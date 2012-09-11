/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Unsafe_Treatment_of_XPath_Input__fromFile_45.java
Label Definition File: CWE643_Unsafe_Treatment_of_XPath_Input.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 643 Unsafe Treatment of XPath Input
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: unvalidatedXPath
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE643_Unsafe_Treatment_of_XPath_Input;

import testcasesupport.*;

import java.io.*;
import javax.xml.xpath.*;
import javax.servlet.http.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE643_Unsafe_Treatment_of_XPath_Input__fromFile_45 extends AbstractTestCase
{

    private String bad_data;
    private String goodG2B_data;
    private String goodB2G_data;

    private void bad_sink() throws Throwable
    {
        String data = bad_data;

        final String xmldoc = "\\src\\testcases\\CWE643_Unsafe_Treatment_of_XPath_Input\\console_to_evaluate\\CWE643_Unsafe_Treatment_of_XPath_Input__helper.xml";

        /* assume username||password as source */
        String [] tokens = data.split("||");
        if( tokens.length < 2 )
        {
            return;
        }
        String uname = tokens[0];
        String pword = tokens[1];

        /* build xpath */
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource inxml = new InputSource(xmldoc);
        /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
         * 	The user input should be canonicalized before validation.
         */
        /* FLAW: user input is used without validate */
        String query = "//users/user[name/text()='" + uname +
        "' and pass/text()='" + pword + "']" +
        "/secret/text()";
        String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);

    }

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        File f = new File("C:\\data.txt");
        BufferedReader buffread = null;
        FileReader fread = null;
        try {
            /* read string from file into data */
            fread = new FileReader(f);
            buffread = new BufferedReader(fread);

            data = buffread.readLine(); // This will be reading the first "line" of the file, which
            // could be very long if there are little or no newlines in the file\
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( fread != null )
                    {
                        fread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing fread");
                }
            }
        }

        bad_data = data;
        bad_sink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2B_sink() throws Throwable
    {
        String data = goodG2B_data;

        final String xmldoc = "\\src\\testcases\\CWE643_Unsafe_Treatment_of_XPath_Input\\console_to_evaluate\\CWE643_Unsafe_Treatment_of_XPath_Input__helper.xml";

        /* assume username||password as source */
        String [] tokens = data.split("||");
        if( tokens.length < 2 )
        {
            return;
        }
        String uname = tokens[0];
        String pword = tokens[1];

        /* build xpath */
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource inxml = new InputSource(xmldoc);
        /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
         * 	The user input should be canonicalized before validation.
         */
        /* FLAW: user input is used without validate */
        String query = "//users/user[name/text()='" + uname +
        "' and pass/text()='" + pword + "']" +
        "/secret/text()";
        String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2B_data = data;
        goodG2B_sink();
    }

    private void goodB2G_sink() throws Throwable
    {
        String data = goodB2G_data;

        final String xmldoc = "\\src\\testcases\\CWE643_Unsafe_Treatment_of_XPath_Input\\console_to_evaluate\\CWE643_Unsafe_Treatment_of_XPath_Input__helper.xml";

        /* assume username||password as source */
        String [] tokens = data.split("||");
        if( tokens.length < 2 )
        {
            return;
        }

        /* FIX: validate input using StringEscapeUtils */
        String uname = StringEscapeUtils.escapeXml(tokens[0]);
        String pword = StringEscapeUtils.escapeXml(tokens[1]);

        /* build xpath */
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource inxml = new InputSource(xmldoc);

        String query = "//users/user[name/text()='" + uname +
        "' and pass/text()='" + pword + "']" +
        "/secret/text()";
        String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        File f = new File("C:\\data.txt");
        BufferedReader buffread = null;
        FileReader fread = null;
        try {
            /* read string from file into data */
            fread = new FileReader(f);
            buffread = new BufferedReader(fread);

            data = buffread.readLine(); // This will be reading the first "line" of the file, which
            // could be very long if there are little or no newlines in the file\
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( fread != null )
                    {
                        fread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing fread");
                }
            }
        }

        goodB2G_data = data;
        goodB2G_sink();
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
