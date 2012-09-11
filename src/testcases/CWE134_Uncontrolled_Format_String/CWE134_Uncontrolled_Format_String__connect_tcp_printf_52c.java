/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__connect_tcp_printf_52c.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__connect_tcp_printf_52c
{

    public void bad_sink(String data ) throws Throwable
    {

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.printf(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.printf(data);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {

        /* FIX: explicitly defined string formatting */
        System.out.printf("%s\n", data);

    }
}
