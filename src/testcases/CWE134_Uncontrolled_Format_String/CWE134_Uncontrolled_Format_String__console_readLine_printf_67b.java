/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__console_readLine_printf_67b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__console_readLine_printf_67b
{

    public void bad_sink(CWE134_Uncontrolled_Format_String__console_readLine_printf_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.printf(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE134_Uncontrolled_Format_String__console_readLine_printf_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.printf(data);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE134_Uncontrolled_Format_String__console_readLine_printf_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        /* FIX: explicitly defined string formatting */
        System.out.printf("%s\n", data);

    }
}
