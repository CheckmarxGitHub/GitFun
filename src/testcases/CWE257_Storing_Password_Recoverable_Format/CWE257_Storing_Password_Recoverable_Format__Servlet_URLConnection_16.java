/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_URLConnection_16.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 257 Storing passwords in a recoverable format
* BadSource: URLConnection Read a string from a web server with URLConnection
* GoodSource: A hardcoded string
* Sinks:
*    GoodSink: one-way hash instead of symmetric crypto
*    BadSink : symmetric encryption with an easy key
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE257_Storing_Password_Recoverable_Format;

import testcasesupport.*;

import java.sql.*;
import java.io.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Logger;

import java.security.MessageDigest;
import java.security.Security;

import javax.servlet.http.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE257_Storing_Password_Recoverable_Format__Servlet_URLConnection_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(true)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from URLConnection */
                instrread = new InputStreamReader(conn.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            }
            break;
        }

        while(true)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            String fp = "../common/config.properties";
            /* simple pre-set key makes the stored password recoverable */
            String sharedKey = "0000000000000000";
            byte[] input = data.getBytes();
            SecretKeySpec key = new SecretKeySpec(sharedKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(input);
            /* FLAW: writing a recoverable password to a cookie */
            response.addCookie(new Cookie("auth", new String(cipherText)));
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");
            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from URLConnection */
                instrread = new InputStreamReader(conn.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            }
            break;
        }

        while(true)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            String fp = "../common/config.properties";
            /* simple pre-set key makes the stored password recoverable */
            String sharedKey = "0000000000000000";
            byte[] input = data.getBytes();
            SecretKeySpec key = new SecretKeySpec(sharedKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(input);
            /* FLAW: writing a recoverable password to a cookie */
            response.addCookie(new Cookie("auth", new String(cipherText)));
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");
            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(true)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from URLConnection */
                instrread = new InputStreamReader(conn.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            }
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            String fp = "../common/config.properties";
            /* simple pre-set key makes the stored password recoverable */
            String sharedKey = "0000000000000000";
            byte[] input = data.getBytes();
            SecretKeySpec key = new SecretKeySpec(sharedKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(input);
            /* FLAW: writing a recoverable password to a cookie */
            response.addCookie(new Cookie("auth", new String(cipherText)));
            break;
        }

        while(true)
        {
            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");
            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
            break;
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
