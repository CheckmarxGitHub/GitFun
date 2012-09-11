/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Access_Through_SQL_Primary__Servlet_53b.java
Label Definition File: CWE566_Access_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 566 Access through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * Sinks: writeConsole
 *    GoodSink: user permissions checked
 *    BadSink : user authorization not checked
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE566_Access_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.security.*;

public class CWE566_Access_Through_SQL_Primary__Servlet_53b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE566_Access_Through_SQL_Primary__Servlet_53c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE566_Access_Through_SQL_Primary__Servlet_53c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE566_Access_Through_SQL_Primary__Servlet_53c()).goodB2G_sink(data , request, response);
    }
}
