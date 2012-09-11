/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__PropertiesFile_printf_66b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: PropertiesFile Read a value from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

public class CWE134_Uncontrolled_Format_String__PropertiesFile_printf_66b
{

    public void bad_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.printf(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.printf(data);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        /* FIX: explicitly defined string formatting */
        System.out.printf("%s\n", data);

    }
}
