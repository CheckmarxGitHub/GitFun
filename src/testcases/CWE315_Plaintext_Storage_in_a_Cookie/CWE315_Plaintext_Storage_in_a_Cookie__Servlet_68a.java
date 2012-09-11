/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68a.java
Label Definition File: CWE315_Plaintext_Storage_in_a_Cookie__Servlet.label.xml
Template File: sources-sinks-68a.tmpl.java
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

public class CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68a extends AbstractTestCaseServlet
{

    public static String data;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        data = "admin:12345";

        (new CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68b()).bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        MessageDigest dig = MessageDigest.getInstance("SHA-512");
        dig.reset();
        byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
        data = new String(bHashedCreds);

        (new CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68b()).goodG2B_sink(request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        data = "admin:12345";

        (new CWE315_Plaintext_Storage_in_a_Cookie__Servlet_68b()).goodB2G_sink(request, response);
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
