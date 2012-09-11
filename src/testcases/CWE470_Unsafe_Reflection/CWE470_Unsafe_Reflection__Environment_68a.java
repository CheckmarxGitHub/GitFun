/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__Environment_68a.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-68a.tmpl.java
*/
/*
 * @description
 * CWE: 470 Unsafe Reflection
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: Hardcoded class to load
 * Sinks:
 *    GoodSink: instantiate only certain fixed classes
 *    BadSink : instantiate arbitrary class
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__Environment_68a extends AbstractTestCase
{

    public static String data;

    public void bad() throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        (new CWE470_Unsafe_Reflection__Environment_68b()).bad_sink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {

        data = "Testing.test";

        (new CWE470_Unsafe_Reflection__Environment_68b()).goodG2B_sink();
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        (new CWE470_Unsafe_Reflection__Environment_68b()).goodB2G_sink();
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
