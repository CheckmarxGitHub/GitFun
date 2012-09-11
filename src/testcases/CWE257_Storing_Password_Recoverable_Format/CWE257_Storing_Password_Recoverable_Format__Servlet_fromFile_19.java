/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_fromFile_19.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-19.tmpl.java
*/
/*
* @description
* CWE: 257 Storing passwords in a recoverable format
* BadSource: fromFile Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* Sinks:
*    GoodSink: one-way hash instead of symmetric crypto
*    BadSink : symmetric encryption with an easy key
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE257_Storing_Password_Recoverable_Format;

import testcasesupport.*;

import java.sql.*;
import java.io.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

import java.security.MessageDigest;
import java.security.Security;

import javax.servlet.http.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE257_Storing_Password_Recoverable_Format__Servlet_fromFile_19 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");

            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());

            response.addCookie(new Cookie("auth", IO.toHex(hashv)));

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

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

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

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

        }
    }

    /* goodB2G() - use badsource and goodsink by switching statements around return */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
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

        {

            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");

            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());

            response.addCookie(new Cookie("auth", IO.toHex(hashv)));

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
