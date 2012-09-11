/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE319_Plaintext_Tx_Sensitive_Info__Servlet_54b.java
Label Definition File: CWE319_Plaintext_Tx_Sensitive_Info__Servlet.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 319 Plaintext Transmission of Sensitive Information
 * BadSource: account_balance Send sensitive information
 * GoodSource: Send non-sensitive information
 * Sinks: non_ssl
 *    GoodSink: Send across SSL connection
 *    BadSink : Send across potentially non-SSL connection
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE319_Plaintext_Tx_Sensitive_Info;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE319_Plaintext_Tx_Sensitive_Info__Servlet_54b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE319_Plaintext_Tx_Sensitive_Info__Servlet_54c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE319_Plaintext_Tx_Sensitive_Info__Servlet_54c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE319_Plaintext_Tx_Sensitive_Info__Servlet_54c()).goodB2G_sink(data , request, response);
    }
}
