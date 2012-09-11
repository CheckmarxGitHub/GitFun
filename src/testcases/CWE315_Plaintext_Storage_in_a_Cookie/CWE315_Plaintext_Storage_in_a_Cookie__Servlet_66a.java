/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE315_Plaintext_Storage_in_a_Cookie__Servlet_66a.java
Label Definition File: CWE315_Plaintext_Storage_in_a_Cookie__Servlet.label.xml
Template File: sources-sinks-66a.tmpl.java
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

public class CWE315_Plaintext_Storage_in_a_Cookie__Servlet_66a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = "admin:12345";

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE315_Plaintext_Storage_in_a_Cookie__Servlet_66b()).bad_sink(data_array , request, response );
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        MessageDigest dig = MessageDigest.getInstance("SHA-512");
        dig.reset();
        byte[] bHashedCreds = dig.digest("admin:12345".getBytes("UTF-8"));
        data = new String(bHashedCreds);

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE315_Plaintext_Storage_in_a_Cookie__Servlet_66b()).goodG2B_sink(data_array , request, response );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = "admin:12345";

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE315_Plaintext_Storage_in_a_Cookie__Servlet_66b()).goodB2G_sink(data_array , request, response );
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
