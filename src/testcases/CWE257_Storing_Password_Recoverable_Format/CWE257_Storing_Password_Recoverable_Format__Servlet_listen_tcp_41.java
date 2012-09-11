/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_listen_tcp_41.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-41.tmpl.java
*/
/*
 * @description
 * CWE: 257 Storing passwords in a recoverable format
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: one-way hash instead of symmetric crypto
 *    BadSink : symmetric encryption with an easy key
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
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
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Logger;

import java.security.MessageDigest;
import java.security.Security;

import javax.servlet.http.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE257_Storing_Password_Recoverable_Format__Servlet_listen_tcp_41 extends AbstractTestCaseServlet
{

    private void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
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

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* Read data using a listening tcp connection */

        ServerSocket listener = null;
        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* read input from socket */
            listener = new ServerSocket(39543);
            sock = listener.accept();

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
            finally {
                try {
                    if( listener != null )
                    {
                        listener.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing listener");
                }
            }
        }

        bad_sink(data , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
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

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2B_sink(data , request, response );
    }

    private void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        String prefix = "Tru3ly 0b$scUre";
        MessageDigest hash = MessageDigest.getInstance("SHA512");

        /* FIX: credentials hashed prior to setting in cookie */
        byte[] hashv = hash.digest((prefix + data).getBytes());

        response.addCookie(new Cookie("auth", IO.toHex(hashv)));

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* Read data using a listening tcp connection */

        ServerSocket listener = null;
        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* read input from socket */
            listener = new ServerSocket(39543);
            sock = listener.accept();

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
            finally {
                try {
                    if( listener != null )
                    {
                        listener.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing listener");
                }
            }
        }

        goodB2G_sink(data , request, response );
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
