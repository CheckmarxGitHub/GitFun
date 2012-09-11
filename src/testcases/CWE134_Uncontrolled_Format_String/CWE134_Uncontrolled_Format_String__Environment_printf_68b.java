/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__Environment_printf_68b.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 134 Uncontrolled Format String
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: printf
 *    GoodSink: dynamic printf format with string defined
 *    BadSink : dynamic printf without validation
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

//!! other imports come from the label definitions

public class CWE134_Uncontrolled_Format_String__Environment_printf_68b
{

    public void bad_sink() throws Throwable
    {
        String data = CWE134_Uncontrolled_Format_String__Environment_printf_68a.data;

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.printf(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        String data = CWE134_Uncontrolled_Format_String__Environment_printf_68a.data;

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.printf(data);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink() throws Throwable
    {
        String data = CWE134_Uncontrolled_Format_String__Environment_printf_68a.data;

        /* FIX: explicitly defined string formatting */
        System.out.printf("%s\n", data);

    }
}
