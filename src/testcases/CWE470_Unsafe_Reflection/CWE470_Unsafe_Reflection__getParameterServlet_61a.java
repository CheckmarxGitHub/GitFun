/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getParameterServlet_61a.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 470 Unsafe Reflection
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: Hardcoded class to load
 * Sinks:
 *    GoodSink: instantiate only certain fixed classes
 *    BadSink : instantiate arbitrary class
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE470_Unsafe_Reflection__getParameterServlet_61a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE470_Unsafe_Reflection__getParameterServlet_61b()).bad_source(request, response);

        Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE470_Unsafe_Reflection__getParameterServlet_61b()).goodG2B_source(request, response);

        Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE470_Unsafe_Reflection__getParameterServlet_61b()).goodB2G_source(request, response);

        if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
        !data.equals("Test.test"))
        {
            return;
        }

        Class<?> c = Class.forName(data);
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

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
