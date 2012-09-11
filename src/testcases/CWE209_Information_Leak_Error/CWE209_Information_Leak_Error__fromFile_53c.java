/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__fromFile_53c.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 209 Information exposure through error message
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: stackDump
 *    GoodSink: Generic error message
 *    BadSink : Error causes stack dump
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__fromFile_53c
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE209_Information_Leak_Error__fromFile_53d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE209_Information_Leak_Error__fromFile_53d()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE209_Information_Leak_Error__fromFile_53d()).goodB2G_sink(data );
    }
}
