/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__listen_tcp_54c.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 470 Unsafe Reflection
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: Hardcoded class to load
 * Sinks:
 *    GoodSink: instantiate only certain fixed classes
 *    BadSink : instantiate arbitrary class
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE470_Unsafe_Reflection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE470_Unsafe_Reflection__listen_tcp_54c
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__listen_tcp_54d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__listen_tcp_54d()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__listen_tcp_54d()).goodB2G_sink(data );
    }
}
