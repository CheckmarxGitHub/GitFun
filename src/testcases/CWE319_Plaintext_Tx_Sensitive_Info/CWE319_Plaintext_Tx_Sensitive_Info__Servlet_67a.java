/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67a.java
Label Definition File: CWE319_Plaintext_Tx_Sensitive_Info__Servlet.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 319 Plaintext Transmission of Sensitive Information
 * BadSource: account_balance Send sensitive information
 * GoodSource: Send non-sensitive information
 * Sinks: non_ssl
 *    GoodSink: Send across SSL connection
 *    BadSink : Send across potentially non-SSL connection
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE319_Plaintext_Tx_Sensitive_Info;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67a extends AbstractTestCaseServlet
{

    static class Container
    {
        public String a;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: sending sensitive information */
        data = "This is your bank account info: Account Number: 12345, Balance: $1,000,000";

        Container data_container = new Container();
        data_container.a = data;
        (new CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67b()).bad_sink(data_container , request, response );
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

        /*FIX: send non-sensitive information */
        data = "The weather is San Diego is 75 and sunny";

        Container data_container = new Container();
        data_container.a = data;
        (new CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67b()).goodG2B_sink(data_container , request, response );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: sending sensitive information */
        data = "This is your bank account info: Account Number: 12345, Balance: $1,000,000";

        Container data_container = new Container();
        data_container.a = data;
        (new CWE319_Plaintext_Tx_Sensitive_Info__Servlet_67b()).goodB2G_sink(data_container , request, response );
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
