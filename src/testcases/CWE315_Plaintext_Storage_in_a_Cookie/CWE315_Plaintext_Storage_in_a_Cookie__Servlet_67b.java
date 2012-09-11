/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_a_Cookie__Servlet_67b.java
Label Definition File: CWE315_Plaintext_Storage_in_a_Cookie__Servlet.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 315 Storing plaintext data in a cookie
 * BadSource:  Plaintext Credentials
 * GoodSource: Hashed Credentials
 * Sinks:
 *    GoodSink: add hashed credentials to cookie
 *    BadSink : add plaintext credentials to cookie
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE315_Plaintext_Storage_in_a_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_a_Cookie__Servlet_67b
{

    public void bad_sink(CWE315_Plaintext_Storage_in_a_Cookie__Servlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
        /* FLAW: plaintext credentials set in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE315_Plaintext_Storage_in_a_Cookie__Servlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
        /* FLAW: plaintext credentials set in cookie */
        response.addCookie(new Cookie("auth", data));

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE315_Plaintext_Storage_in_a_Cookie__Servlet_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_container.a;

        String secretHash = "my_secret_seed";
        MessageDigest hash = MessageDigest.getInstance("SHA1");

        /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
        byte[] hashv = hash.digest((secretHash + data).getBytes());

        response.addCookie(new Cookie("auth", IO.toHex(hashv)));

    }
}
