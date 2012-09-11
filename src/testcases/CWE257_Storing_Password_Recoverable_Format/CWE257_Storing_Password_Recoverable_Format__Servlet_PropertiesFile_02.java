/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_PropertiesFile_02.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-02.tmpl.java
*/
/*
* @description
* CWE: 257 Storing passwords in a recoverable format
* BadSource: PropertiesFile Read a value from a .properties file (in property named data)
* GoodSource: A hardcoded string
* Sinks:
*    GoodSink: one-way hash instead of symmetric crypto
*    BadSink : symmetric encryption with an easy key
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE257_Storing_Password_Recoverable_Format;

import testcasesupport.*;

import java.sql.*;
import java.io.*;
import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

import java.security.MessageDigest;
import java.security.Security;

import javax.servlet.http.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE257_Storing_Password_Recoverable_Format__Servlet_PropertiesFile_02 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
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
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");

            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());

            response.addCookie(new Cookie("auth", IO.toHex(hashv)));

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first true to false */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(false)
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
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");

            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());

            response.addCookie(new Cookie("auth", IO.toHex(hashv)));

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
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
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");

            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());

            response.addCookie(new Cookie("auth", IO.toHex(hashv)));

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second true to false */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
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
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(false)
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
        }
        else {

            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");

            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());

            response.addCookie(new Cookie("auth", IO.toHex(hashv)));

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
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
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(true)
        {
            String prefix = "Tru3ly 0b$scUre";
            MessageDigest hash = MessageDigest.getInstance("SHA512");
            /* FIX: credentials hashed prior to setting in cookie */
            byte[] hashv = hash.digest((prefix + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
        }
        else {
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

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
