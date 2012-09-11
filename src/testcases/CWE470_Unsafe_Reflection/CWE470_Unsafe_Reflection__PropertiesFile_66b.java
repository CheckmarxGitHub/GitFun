/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__PropertiesFile_66b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Unsafe Reflection
 * BadSource: PropertiesFile Read a value from a .properties file (in property named data)
 * GoodSource: Hardcoded class to load
 * Sinks:
 *    GoodSink: instantiate only certain fixed classes
 *    BadSink : instantiate arbitrary class
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE470_Unsafe_Reflection__PropertiesFile_66b
{

    public void bad_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

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
