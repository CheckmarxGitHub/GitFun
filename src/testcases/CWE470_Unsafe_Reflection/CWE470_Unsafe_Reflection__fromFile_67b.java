/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__fromFile_67b.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 470 Unsafe Reflection
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: Hardcoded class to load
 * Sinks:
 *    GoodSink: instantiate only certain fixed classes
 *    BadSink : instantiate arbitrary class
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE470_Unsafe_Reflection__fromFile_67b
{

    public void bad_sink(CWE470_Unsafe_Reflection__fromFile_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE470_Unsafe_Reflection__fromFile_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        Class<?> c = Class.forName(data); /* FLAW: loading arbitrary class */
        Object instance = c.newInstance();

        IO.writeLine(instance.toString());

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE470_Unsafe_Reflection__fromFile_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

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
