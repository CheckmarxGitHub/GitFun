/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_URLConnection_54e.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-54e.tmpl.java
*/
/*
 * @description
 * CWE: 257 Storing passwords in a recoverable format
 * BadSource: URLConnection Read a string from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: one-way hash instead of symmetric crypto
 *    BadSink : symmetric encryption with an easy key
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
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

public class CWE257_Storing_Password_Recoverable_Format__Servlet_URLConnection_54e
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
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
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
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

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        String prefix = "Tru3ly 0b$scUre";
        MessageDigest hash = MessageDigest.getInstance("SHA512");

        /* FIX: credentials hashed prior to setting in cookie */
        byte[] hashv = hash.digest((prefix + data).getBytes());

        response.addCookie(new Cookie("auth", IO.toHex(hashv)));

    }
}