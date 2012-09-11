/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_connect_tcp_53b.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 257 Storing passwords in a recoverable format
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: one-way hash instead of symmetric crypto
 *    BadSink : symmetric encryption with an easy key
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE257_Storing_Password_Recoverable_Format;

import testcasesupport.*;

import java.sql.*;
import java.io.*;
import javax.servlet.http.*;

import java.security.MessageDigest;
import java.security.Security;

import javax.servlet.http.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CWE257_Storing_Password_Recoverable_Format__Servlet_connect_tcp_53b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE257_Storing_Password_Recoverable_Format__Servlet_connect_tcp_53c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE257_Storing_Password_Recoverable_Format__Servlet_connect_tcp_53c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE257_Storing_Password_Recoverable_Format__Servlet_connect_tcp_53c()).goodB2G_sink(data , request, response);
    }
}
