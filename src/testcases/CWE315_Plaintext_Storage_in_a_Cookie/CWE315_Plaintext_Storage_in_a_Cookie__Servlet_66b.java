/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_a_Cookie__Servlet_66b.java
Label Definition File: CWE315_Plaintext_Storage_in_a_Cookie__Servlet.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Plaintext Credentials
 * GoodSource: Hashed Credentials
 * Sinks:
 *    GoodSink: add hashed credentials to cookie
 *    BadSink : add plaintext credentials to cookie
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_a_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_a_Cookie__Servlet_66b
{

    public void bad_sink(String data_array[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_array[2];

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
        /* FLAW: plaintext credentials set in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data_array[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_array[2];

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
        /* FLAW: plaintext credentials set in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data_array[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_array[2];

        String secretHash = "my_secret_seed";
        MessageDigest hash = MessageDigest.getInstance("SHA1");

        /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
        byte[] hashv = hash.digest((secretHash + data).getBytes());

        response.addCookie(new Cookie("auth", IO.toHex(hashv)));

    }
}
