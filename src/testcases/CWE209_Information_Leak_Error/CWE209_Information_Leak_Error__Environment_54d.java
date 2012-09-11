/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__Environment_54d.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 209 Information exposure through error message
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: stackDump
 *    GoodSink: Generic error message
 *    BadSink : Error causes stack dump
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__Environment_54d
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE209_Information_Leak_Error__Environment_54e()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE209_Information_Leak_Error__Environment_54e()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE209_Information_Leak_Error__Environment_54e()).goodB2G_sink(data );
    }
}
