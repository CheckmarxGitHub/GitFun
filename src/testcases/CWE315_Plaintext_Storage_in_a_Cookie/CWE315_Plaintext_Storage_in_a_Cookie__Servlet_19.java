/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_a_Cookie__Servlet_19.java
Label Definition File: CWE315_Plaintext_Storage_in_a_Cookie__Servlet.label.xml
Template File: sources-sinks-19.tmpl.java
*/
/*
* @description
* CWE: 315 Storing plaintext data in a cookie
* BadSource:  Plaintext Credentials
* GoodSource: Hashed Credentials
* Sinks:
*    GoodSink: add hashed credentials to cookie
*    BadSink : add plaintext credentials to cookie
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE315_Plaintext_Storage_in_a_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_a_Cookie__Servlet_19 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = "admin:12345";

        {

            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");

            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());

            response.addCookie(new Cookie("auth", IO.toHex(hashv)));

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
            data = new String(bHashedCreds);

            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            data = "admin:12345";

            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));

        }
    }

    /* goodB2G() - use badsource and goodsink by switching statements around return */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = "admin:12345";

        {

            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");

            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());

            response.addCookie(new Cookie("auth", IO.toHex(hashv)));

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));

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
