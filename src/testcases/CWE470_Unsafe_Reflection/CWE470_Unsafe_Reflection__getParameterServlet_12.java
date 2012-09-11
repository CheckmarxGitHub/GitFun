/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getParameterServlet_12.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 470 Unsafe Reflection
* BadSource: getParameterServlet Read data from a querystring using getParameter
* GoodSource: Hardcoded class to load
* Sinks:
*    GoodSink: instantiate only certain fixed classes
*    BadSink : instantiate arbitrary class
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__getParameterServlet_12 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {

            data = "Testing.test";

        }
        if(IO.static_returns_t_or_f())
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            data = "Testing.test";
        }
        else {

            data = "Testing.test";

        }
        if(IO.static_returns_t_or_f())
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {

            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from request */
            data = request.getParameter("name");

        }
        if(IO.static_returns_t_or_f())
        {
            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
                    !data.equals("Test.test"))
            {
                return;
            }
            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {

            if (!data.equals("Testing.test") &&  /* FIX: classname must be one of 2 values */
            !data.equals("Test.test"))
            {
                return;
            }

            Class<?> c = Class.forName(data);
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
