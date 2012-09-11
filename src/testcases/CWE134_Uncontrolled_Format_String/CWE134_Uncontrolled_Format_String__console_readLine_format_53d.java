/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__console_readLine_format_53d.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-53d.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__console_readLine_format_53d
{

    public void bad_sink(String data ) throws Throwable
    {

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.format(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.format(data);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {

        /* FIX: explicitly defined string formatting */
        System.out.format("%s\n", data);

    }
}
