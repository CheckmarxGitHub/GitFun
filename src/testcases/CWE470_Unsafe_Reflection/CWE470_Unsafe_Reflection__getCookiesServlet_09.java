/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__getCookiesServlet_09.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-09.tmpl.java
*/
/*
* @description
* CWE: 470 Unsafe Reflection
* BadSource: getCookiesServlet Read data from the first cookie
* GoodSource: Hardcoded class to load
* Sinks:
*    GoodSink: instantiate only certain fixed classes
*    BadSink : instantiate arbitrary class
* Flow Variant: 09 Control flow: if(IO.static_final_t) and if(IO.static_final_f)
*
* */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__getCookiesServlet_09 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_final_t)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from cookie */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue();
            }
            else
            {
                data = null;
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "Testing.test";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_final_t)
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_final_t to IO.static_final_f */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(IO.static_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from cookie */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue();
            }
            else
            {
                data = null;
            }
        }
        else {

            data = "Testing.test";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_final_t)
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_final_t)
        {
            data = "Testing.test";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from cookie */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue();
            }
            else
            {
                data = null;
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_final_t)
        {
            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();
            IO.writeLine(instance.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_final_t to IO.static_final_f */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_final_t)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from cookie */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue();
            }
            else
            {
                data = null;
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "Testing.test";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(IO.static_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_final_t)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from cookie */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue();
            }
            else
            {
                data = null;
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "Testing.test";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(IO.static_final_t)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
            Object instance = c.newInstance();

            IO.writeLine(instance.toString());

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
