/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_getParameterServlet_13.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-13.tmpl.java
*/
/*
* @description
* CWE: 257 Storing passwords in a recoverable format
* BadSource: getParameterServlet Read data from a querystring using getParameter
* GoodSource: A hardcoded string
* Sinks:
*    GoodSink: one-way hash instead of symmetric crypto
*    BadSink : symmetric encryption with an easy key
* Flow Variant: 13 Control flow: if(IO.static_final_five==5) and if(IO.static_final_five!=5)
*
* */

package testcases.CWE257_Storing_Password_Recoverable_Format;

import testcasesupport.*;

import java.sql.*;
import java.io.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

import java.security.MessageDigest;
import java.security.Security;

import javax.servlet.http.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE257_Storing_Password_Recoverable_Format__Servlet_getParameterServlet_13 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_final_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_final_five==5)
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

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_final_five==5 to IO.static_final_five!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_final_five==5)
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
        if(IO.static_final_five==5)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from request */
            data = request.getParameter("name");

        }
        if(IO.static_final_five==5)
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

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_final_five==5 to IO.static_final_five!=5 */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_final_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_final_five!=5)
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
        if(IO.static_final_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_final_five==5)
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
