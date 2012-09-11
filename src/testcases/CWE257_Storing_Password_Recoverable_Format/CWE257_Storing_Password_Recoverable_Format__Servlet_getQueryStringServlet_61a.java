/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_getQueryStringServlet_61a.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 257 Storing passwords in a recoverable format
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: one-way hash instead of symmetric crypto
 *    BadSink : symmetric encryption with an easy key
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE257_Storing_Password_Recoverable_Format;

import testcasesupport.*;

import java.sql.*;
import java.io.*;
import javax.servlet.http.*;

import java.security.MessageDigest;
import java.security.Security;

import javax.servlet.http.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE257_Storing_Password_Recoverable_Format__Servlet_getQueryStringServlet_61a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE257_Storing_Password_Recoverable_Format__Servlet_getQueryStringServlet_61b()).bad_source(request, response);

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

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE257_Storing_Password_Recoverable_Format__Servlet_getQueryStringServlet_61b()).goodG2B_source(request, response);

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE257_Storing_Password_Recoverable_Format__Servlet_getQueryStringServlet_61b()).goodB2G_source(request, response);

        String prefix = "Tru3ly 0b$scUre";
        MessageDigest hash = MessageDigest.getInstance("SHA512");

        /* FIX: credentials hashed prior to setting in cookie */
        byte[] hashv = hash.digest((prefix + data).getBytes());

        response.addCookie(new Cookie("auth", IO.toHex(hashv)));

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
