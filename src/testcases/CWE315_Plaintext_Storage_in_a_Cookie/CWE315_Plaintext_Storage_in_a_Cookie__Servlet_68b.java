/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68b.java
Label Definition File: CWE315_Plaintext_Storage_in_a_Cookie__Servlet.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Plaintext Credentials
 * GoodSource: Hashed Credentials
 * Sinks:
 *    GoodSink: add hashed credentials to cookie
 *    BadSink : add plaintext credentials to cookie
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_a_Cookie;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68b
{

    public void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68a.data;

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
        /* FLAW: plaintext credentials set in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68a.data;

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
        /* FLAW: plaintext credentials set in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68a.data;

        String secretHash = "my_secret_seed";
        MessageDigest hash = MessageDigest.getInstance("SHA1");

        /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
        byte[] hashv = hash.digest((secretHash + data).getBytes());

        response.addCookie(new Cookie("auth", IO.toHex(hashv)));

    }
}
