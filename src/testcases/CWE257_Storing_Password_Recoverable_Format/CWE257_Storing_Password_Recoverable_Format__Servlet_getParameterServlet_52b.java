/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE257_Storing_Password_Recoverable_Format__Servlet_getParameterServlet_52b.java
Label Definition File: CWE257_Storing_Password_Recoverable_Format__Servlet.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 257 Storing passwords in a recoverable format
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: one-way hash instead of symmetric crypto
 *    BadSink : symmetric encryption with an easy key
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
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

public class CWE257_Storing_Password_Recoverable_Format__Servlet_getParameterServlet_52b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE257_Storing_Password_Recoverable_Format__Servlet_getParameterServlet_52c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE257_Storing_Password_Recoverable_Format__Servlet_getParameterServlet_52c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE257_Storing_Password_Recoverable_Format__Servlet_getParameterServlet_52c()).goodB2G_sink(data , request, response);
    }
}
