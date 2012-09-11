/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__Environment_61b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Unsafe Reflection
 * BadSource: Environment Read a string from an environment variable
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

import java.util.logging.Logger;

public class CWE470_Unsafe_Reflection__Environment_61b
{

    public String bad_source() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public String goodG2B_source() throws Throwable
    {
        String data;

        data = "Testing.test";

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public String goodB2G_source() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        return data;
    }
}
