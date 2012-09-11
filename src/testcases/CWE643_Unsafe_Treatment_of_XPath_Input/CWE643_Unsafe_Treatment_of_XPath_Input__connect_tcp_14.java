/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Unsafe_Treatment_of_XPath_Input__connect_tcp_14.java
Label Definition File: CWE643_Unsafe_Treatment_of_XPath_Input.label.xml
Template File: sources-sinks-14.tmpl.java
*/
/*
* @description
* CWE: 643 Unsafe Treatment of XPath Input
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded string
* Sinks: unvalidatedXPath
*    GoodSink: validate input through StringEscapeUtils
*    BadSink : user input is used without validate
* Flow Variant: 14 Control flow: if(IO.static_five==5) and if(IO.static_five!=5)
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
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Logger;

public class CWE643_Unsafe_Treatment_of_XPath_Input__connect_tcp_14 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);
                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_five==5)
        {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);
                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_five==5)
        {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            data = ""; /* init data */

            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);

                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);

                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }

        }
        if(IO.static_five==5)
        {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
    }

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_five==5 to IO.static_five!=5 */
    private void goodB2G1() throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);
                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        else {

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
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);
                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
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
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_five==5)
        {
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
