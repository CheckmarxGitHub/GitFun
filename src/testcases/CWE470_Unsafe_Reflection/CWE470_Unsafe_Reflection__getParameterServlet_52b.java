/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getParameterServlet_52b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Unsafe Reflection
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: Hardcoded class to load
 * Sinks:
 *    GoodSink: instantiate only certain fixed classes
 *    BadSink : instantiate arbitrary class
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE470_Unsafe_Reflection__getParameterServlet_52b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__getParameterServlet_52c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__getParameterServlet_52c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__getParameterServlet_52c()).goodB2G_sink(data , request, response);
    }
}
