/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_a_Cookie__Servlet_15.java
Label Definition File: CWE315_Plaintext_Storage_in_a_Cookie__Servlet.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 315 Storing plaintext data in a cookie
* BadSource:  Plaintext Credentials
* GoodSource: Hashed Credentials
* Sinks:
*    GoodSink: add hashed credentials to cookie
*    BadSink : add plaintext credentials to cookie
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE315_Plaintext_Storage_in_a_Cookie;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class CWE315_Plaintext_Storage_in_a_Cookie__Servlet_15 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            data = "admin:12345";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
            data = new String(bHashedCreds);
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");
            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
        }
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            data = "admin:12345";
        }
        break;
        default:
        {
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
            data = new String(bHashedCreds);
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");
            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
        }
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
            data = new String(bHashedCreds);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            data = "admin:12345";
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");
            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
        }
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            data = "admin:12345";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
            data = new String(bHashedCreds);
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        break;
        default:
        {
            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");
            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
        }
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            data = "admin:12345";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            MessageDigest dig = MessageDigest.getInstance("SHA-512");
            dig.reset();
            byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
            data = new String(bHashedCreds);
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            String secretHash = "my_secret_seed";
            MessageDigest hash = MessageDigest.getInstance("SHA1");
            /* FIX: plaintext credentials hashed with salt prior to setting in cookie */
            byte[] hashv = hash.digest((secretHash + data).getBytes());
            response.addCookie(new Cookie("auth", IO.toHex(hashv)));
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            /* NOTE: potential incidental issues with not setting secure or HttpOnly flag */
            /* FLAW: plaintext credentials set in cookie */
            response.addCookie(new Cookie("auth", data));
        }
        break;
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
