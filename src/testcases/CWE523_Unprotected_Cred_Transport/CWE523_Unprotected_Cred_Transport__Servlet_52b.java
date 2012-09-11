/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE523_Unprotected_Cred_Transport__Servlet_52b.java
Label Definition File: CWE523_Unprotected_Cred_Transport__Servlet.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 523 Unprotected Transportation of Credentials
 * BadSource: credentials Send login credentials
 * GoodSource: Send non-sensitive information
 * Sinks: non_ssl
 *    GoodSink: Send across SSL connection
 *    BadSink : Send across potentially non-SSL connection
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE523_Unprotected_Cred_Transport;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE523_Unprotected_Cred_Transport__Servlet_52b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE523_Unprotected_Cred_Transport__Servlet_52c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE523_Unprotected_Cred_Transport__Servlet_52c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE523_Unprotected_Cred_Transport__Servlet_52c()).goodB2G_sink(data , request, response);
    }
}
