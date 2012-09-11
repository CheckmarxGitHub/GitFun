/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__Environment_format_54b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: format
 *    GoodSink: dynamic formatted stdout with string defined
 *    BadSink : dynamic formatted stdout without validation
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__Environment_format_54b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE134_Uncontrolled_Format_String__Environment_format_54c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE134_Uncontrolled_Format_String__Environment_format_54c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE134_Uncontrolled_Format_String__Environment_format_54c()).goodB2G_sink(data );
    }
}
