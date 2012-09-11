/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_a_Cookie__Servlet_16.java
Label Definition File: CWE315_Plaintext_Storage_in_a_Cookie__Servlet.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 315 Storing plaintext data in a cookie
* BadSource:  Plaintext Credentials
* GoodSource: Hashed Credentials
* Sinks:
*    GoodSink: add hashed credentials to cookie
*    BadSink : add plaintext credentials to cookie
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE315_Plaintext_Storage_in_a_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_a_Cookie__Servlet_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
            data = new String(bHashedCreds);
            break;
        }

        while(true)
        {
            data = "admin:12345";
            break;
        }

        while(true)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");
            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
            data = new String(bHashedCreds);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = "admin:12345";
            break;
        }

        while(true)
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");
            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
            data = new String(bHashedCreds);
            break;
        }

        while(true)
        {
            data = "admin:12345";
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));
            break;
        }

        while(true)
        {
            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");
            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
            break;
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
