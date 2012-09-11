/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE523_Unprotected_Cred_Transport__Servlet_53c.java
Label Definition File: CWE523_Unprotected_Cred_Transport__Servlet.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 523 Unprotected Transportation of Credentials
 * BadSource: credentials Send login credentials
 * GoodSource: Send non-sensitive information
 * Sinks: non_ssl
 *    GoodSink: Send across SSL connection
 *    BadSink : Send across potentially non-SSL connection
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE523_Unprotected_Cred_Transport;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE523_Unprotected_Cred_Transport__Servlet_53c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE523_Unprotected_Cred_Transport__Servlet_53d()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE523_Unprotected_Cred_Transport__Servlet_53d()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE523_Unprotected_Cred_Transport__Servlet_53d()).goodB2G_sink(data , request, response);
    }
}
